package com.grosup.practice.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.grosup.practice.beans.StatisticsBean;
import com.grosup.practice.dao.StatisticsDao;
import com.grosup.practice.util.GrosupException;
import com.grosup.practice.util.ObjectUtil;

@Component
public class RankingTask {
	
	private static Logger logger = Logger.getLogger(RankingTask.class);
	
	@Autowired
	private StatisticsDao statisticsDao;
	
//	@Scheduled(cron="0 0 6 * * ?") //每天早上六点触发
	 @Scheduled(cron="0 0/5 * * * ? ") //间隔5分执行  
	public void getRanking() {
		logger.debug("定时任务开始啦 哈哈哈");
		System.out.println("定时任务开始啦 哈哈哈");
		try {
			List<StatisticsBean> list = statisticsDao.getUsersRankInfo();
//			for (StatisticsBean statisticsBean : list) {
//				System.out.println(statisticsBean.toString());
//				statisticsBean.setHighestWrongType(statisticsDao.getUserHighestWrong(statisticsBean.getUserID()));
//			}
			if (ObjectUtil.isNotNull(list) && list.size() > 0) {
				statisticsDao.usersRankInfoAdd(list);
			}
		} catch (GrosupException e) {
			logger.error("执行定时任务异常", e);
		}
		
	}
}