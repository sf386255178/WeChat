package com.kevin.service;

import com.kevin.util.ExcleUtil;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/10/15
 * TODO:文件上传
 */
@Service
public class FileService {

    @Resource
    private NutDao dao;
    public  String upFile(MultipartFile file){
        String msg = "";
        if (file!=null && !file.isEmpty()){
            try {
                final List<Map> excel = ExcleUtil.readExcel(file);
                final List<Record> bi = new ArrayList<Record>();
                if (excel.get(0).containsKey("shop_id")){
//                        for (int i = 0 ; i<excel.size();i++){
//                            String shop_id = String.valueOf(excel.get(i).get("shop_id"));
//                            Record record = new Record();
//                            record.put("shop_id",shop_id);
//                            record.put(".table","shop");
//                            bi.add(record);
//                            dao.fastInsert(record);
//                        }

//                        msg = "插入数据库成功";
                    final int size = excel.size();
                    final int nThread = size/10+1;//线程数量
                    if (size%nThread != 0){
                        Record last = new Record();
                        last.put("shop_id",excel.get(size-1).get("shop_id").toString());
                        last.put(".table","shop");
                        dao.fastInsert(last);
                        System.out.println("插入末值成功");
                    }
                    ExecutorService executorService = Executors.newFixedThreadPool(nThread);
                    List<Future<String>> futures = new ArrayList();//封装子程返回的结果
                    for (int i = 0; i < nThread; i++) {
                        //返回一个子集合 ,左开右闭
                        final List<Map> subList = excel.subList(size/nThread * i ,size/nThread*(i+1));
                        Callable<String> task = new Callable<String>() {//每个子程的具体实现
                            @Override
                                public String call() throws Exception {
                                List info = new ArrayList();
                                for (int j = 0; j < subList.size(); j++) {
                                    Record data = new Record();
                                    String shop_id = String.valueOf(subList.get(j).get("shop_id"));
                                    data.put("shop_id",shop_id);
                                    data.put(".table","shop");
                                    info.add(data);
                                }
                                dao.fastInsert(info);

                                return "子程运行结束"+Thread.currentThread().getName();
                            }
                        };
                        futures.add(executorService.submit(task));//运行子程
                    }
                    for (Future<String> future : futures) {//得到每个子程的结果（返回值）
                        System.out.println(future.get());
                    }
                    executorService.shutdown();//关闭线程
                }else {
                    msg = "数据格式不规范";
                    return msg;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null ;

    }

}