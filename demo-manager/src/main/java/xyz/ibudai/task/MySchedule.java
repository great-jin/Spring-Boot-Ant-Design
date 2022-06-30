package xyz.ibudai.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MySchedule {

    private final Logger logger = LoggerFactory.getLogger(MySchedule.class);

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 定时任务，每10分钟打印一次时间
     */
    @Scheduled(fixedRate = 600000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
    }
}
