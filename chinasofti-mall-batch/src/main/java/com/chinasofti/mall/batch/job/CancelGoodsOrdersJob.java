package com.chinasofti.mall.batch.job;

import com.chinasofti.mall.batch.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class CancelGoodsOrdersJob {

    private static Logger logger = Logger.getLogger(CancelGoodsOrdersJob.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("job/CancelGoodsOrdersJob.xml");

        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("cancelGoodsOrdersJob");

        try {
            String handleDate = "" ;

            /**
             * 验证入参的格式
             */
            if (args!=null && args.length>0 &&args[0]!=null&&!"".equals(args[0])){
                if(!DateUtils.isValidDate(args[0])){
                    throw new Exception("入参为："+args[0]+",请检查入参格式是否正确！示例:20170224");
                }else{
                    handleDate = DateUtils.getDateTime(args[0]) ;
                }
            }else{
                Date now = new Date();
                handleDate = DateUtils.getNowDate(now) ;
            }

            logger.info("CancelGoodsOrdersJob在 " + DateUtils.getCurrentTime() + "开始执行...");
            /* 运行Job */
            JobExecution result = launcher.run(job, new JobParametersBuilder()
                    .addString("handleDate", handleDate)
                    .toJobParameters());
			/* 处理结束，控制台打印处理结果 */
            logger.info(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            ((ConfigurableApplicationContext) context).close();
        }
    }
}
