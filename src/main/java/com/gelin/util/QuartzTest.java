package com.gelin.util;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 葛林 on 2017/7/18.
 * 任务调度
 */
public class QuartzTest implements Job {
    /**
     * 第二种方式获取，通过set方法
     * 引用名称必须与对应的key值相同
     */
   /* private String message;
    private Float mathjob;
    private Double DoubleTrigger;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getMathjob() {
        return mathjob;
    }

    public void setMathjob(Float mathjob) {
        this.mathjob = mathjob;
    }

    public Double getDoubleTrigger() {
        return DoubleTrigger;
    }

    public void setDoubleTrigger(Double doubleTrigger) {
        DoubleTrigger = doubleTrigger;
    }*/
    @Override//业务逻辑
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        /*JobKey key=jobExecutionContext.getJobDetail().getKey();
        System.out.println("name:"+key.getName()+"; group:"+key.getGroup());
        TriggerKey triggerKey=jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger:"+triggerKey.getName()+"; group:"+triggerKey.getGroup());
        *//**
         *获取方式一
         *//*
        JobDataMap dataMap=jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap trDataMap=jobExecutionContext.getTrigger().getJobDataMap();
        String jobMsg=dataMap.getString("message");
        Float f=dataMap.getFloat("mathjob");
        String triMsg=trDataMap.getString("message");
        Double d=trDataMap.getDouble("DoubleTrigger");
        //System.out.println(jobMsg+"; "+f+"; trigger:"+triMsg+"; "+d);
        JobDataMap jobDataMap=jobExecutionContext.getMergedJobDataMap();//合并后的，将getJobDetail，和getTrigger
        Float f1=jobDataMap.getFloat("mathjob");
        Double d1=jobDataMap.getDouble("DoubleTrigger");
        System.out.println(message);//如果JobDetail和Trigger的key相同，则Trigger会覆盖JobDetail的值
        System.out.println(mathjob+";;;"+DoubleTrigger);*/


        /*Trigger currentTrigger=jobExecutionContext.getTrigger();
        System.out.println("开始时间;"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTrigger.getStartTime()));
        System.out.println("结束时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTrigger.getEndTime()));
        JobKey jobKey=currentTrigger.getJobKey();
        System.out.println("jobKey info---:"+
                "jobName"+jobKey.getName()+"; jobgroup"+jobKey.getGroup());*/

        System.out.println("hello gelin");


    }
}

/**
 * job在Quartz中的生命周期；
 * 每次调度器执行job时，它在调用execute方法前会创建一个新的job实例。
 * 当调用完成后，关联的job对象实例会被释放，释放的实例会被回收
 * <p>
 * JobDetail的重要属性
 * <p>
 * name
 * group
 * jobClass
 * jobDataMap
 * <p>
 * JobExecutionContext
 * <p>
 * 当Scheduler调用一个Job，就会将JobExecutionContext传递给Job的execute()方法；
 * Job能通过JobExecutionContext对象访问到Quartz运行时候的环境以及job本身的明细数据
 * <p>
 * JobDataMap
 * <p>
 * 在进行任务调度时jobDataMap存储在JobExecutionContext中，非常方便获取。
 * JobDataMap可以用来装载任何可序列化的数据对象，当job实例对象被执行时这些参数对象会传递给它。
 * JobDataMap实现了JDK的map接口，并且添加了一些非常方便的方法用老存储基本数据类型。
 * <p>
 * 获取：如上
 * <p>
 * trigger
 * <p>
 * Quartz中的触发器用来告诉调度程序作业什么时候触发。是用来触发执行Job的
 * 实现类：
 * CrontriggerImpl;常用
 * SimpleTriggerImpl;常用
 * DailyTimeIntervalTriggerImpl
 * CalendarIntervalTriggerImpl
 * <p>
 * 通用属性
 * <p>
 * 1.JobKey  表示job实例的标识，触发器被触发时，该指定的job实例会执行
 * 2.StartTime  表示触发器的时间表首次被触发的时间。类型是java.util.Date
 * 3.EndTime  指定触发器的不再被触发的时间。类型是java.util.Date
 * <p>
 * <p>
 * SimpleTrigger
 * <p>
 * 在一个指定时间段内执行一次作业任务或是在指定的时间间隔内多次执行作业任务
 * <p>
 * CronTrigger
 * <p>
 * 基于日历的作业调度器，
 * 而不是像SimpleTrigger那样精确指定时间间隔，比SimpleTrigger更常用
 * <p>
 * Cron表达式（看看CronTable）
 * <p>
 * 用于配置CronTrigger实例。
 * 是由7个子表达式组成的字符串，描述了时间表的详细信息。
 * 格式:[秒][分][小时][日][月][周][年]
 * <p>
 * Seconds:可出现", - * /"四个字符，有效范围为0-59的整数
 * Minutes:可出现", - * /"四个字符，有效范围为0-59的整数
 * Hours:可出现", - * /"四个字符，有效范围为0-23的整数
 * DayofMonth:可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
 * Month:可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
 * DayofWeek:可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
 * Year:可出现", - * /"四个字符，有效范围为1970-2099年
 * <p>
 * 每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是
 * <p>
 * 1. *：表示匹配该域的任意值，假如在Minutes域使用*, 即表示每分钟都会触发事件。
 * 2. ?:只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。
 * 因为DayofMonth和 DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，
 * 则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，
 * 实际上并不是这样。
 * 3. -:表示范围，例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
 * 4. /：表示起始时间开始触发，然后每隔固定时间触发一次，例如在Minutes域使用5/20,则意味着从5分钟开始，
 * 每20触发一次.
 * 5. ,:表示列出枚举值值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
 * 6. L:表示最后，只能出现在DayofWeek和DayofMonth域，如果在DayofWeek域使用5L,意味着在最后的一个星期四触发
 * 7. W: 表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。
 * 例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：
 * 星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一 到星期五中的一天，
 * 则就在5日触发。另外一点，W的最近寻找不会跨过月份
 * 8. LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五
 * 9. #:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。
 * <p>
 * 举几个例子:
 * 0 0 2 1 * ? * 表示在每月的1日的凌晨2点调度任务
 * 0 15 10 ? * MON-FRI 表示周一到周五每天上午10：15执行作业
 * 0 15 10 ? 6L 2002-2006 表示2002-2006年的每个月的最后一个星期五上午10:15执行作
 * <p>
 * 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?
 * <p>
 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 * 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
 * 0 0 12 ? * WED 表示每个星期三中午12点
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 * <p>
 * 有些子表达式能包含一些范围或列表
 * <p>
 * 例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”
 * <p>
 * “*”字符代表所有可能的值
 * <p>
 * 因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天
 * <p>
 * <p>
 * “/”字符用来指定数值的增量
 * 例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
 * 在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
 * <p>
 * <p>
 * “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
 * 当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
 * <p>
 * “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
 * 但是它在两个子表达式里的含义是不同的。
 * 在天（月）子表达式中，“L”表示一个月的最后一天
 * 在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT
 * <p>
 * 如果在“L”前有具体的内容，它就具有其他的含义了
 * <p>
 * 例如：“6L”表示这个月的倒数第６天，“FRIL”表示这个月的最一个星期五
 * 注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题
 * <p>
 * 字段 允许值 允许的特殊字符
 * 秒 0-59 , - * /
 * 分 0-59 , - * /
 * 小时 0-23 , - * /
 * 日期 1-31 , - * ? / L W C
 * 月份 1-12 或者 JAN-DEC , - * /
 * 星期 1-7 或者 SUN-SAT , - * ? / L C #
 * 年（可选） 留空, 1970-2099 , - * /
 * <p>
 * <p>
 * StdSchedulerFactory
 * <p>
 * 使用一组参数Properties来创建和初始化Quartz调度器
 * 配置参数一般存储在quartz.properties中
 */

/**
 *JobDetail的重要属性
 *
 * name
 * group
 * jobClass
 * jobDataMap
 */

/**
 * JobExecutionContext
 *
 * 当Scheduler调用一个Job，就会将JobExecutionContext传递给Job的execute()方法；
 * Job能通过JobExecutionContext对象访问到Quartz运行时候的环境以及job本身的明细数据
 */

/**
 * JobDataMap
 *
 * 在进行任务调度时jobDataMap存储在JobExecutionContext中，非常方便获取。
 * JobDataMap可以用来装载任何可序列化的数据对象，当job实例对象被执行时这些参数对象会传递给它。
 * JobDataMap实现了JDK的map接口，并且添加了一些非常方便的方法用老存储基本数据类型。
 *
 * 获取：如上
 */


/**
 * trigger
 *
 * Quartz中的触发器用来告诉调度程序作业什么时候触发。是用来触发执行Job的
 * 实现类：
 * CrontriggerImpl;常用
 * SimpleTriggerImpl;常用
 * DailyTimeIntervalTriggerImpl
 * CalendarIntervalTriggerImpl
 *
 *通用属性
 *
 * 1.JobKey  表示job实例的标识，触发器被触发时，该指定的job实例会执行
 *2.StartTime  表示触发器的时间表首次被触发的时间。类型是java.util.Date
 *3.EndTime  指定触发器的不再被触发的时间。类型是java.util.Date
 *
 */

/**
 * SimpleTrigger
 *
 * 在一个指定时间段内执行一次作业任务或是在指定的时间间隔内多次执行作业任务
 */

/**
 * CronTrigger
 *
 * 基于日历的作业调度器，
 * 而不是像SimpleTrigger那样精确指定时间间隔，比SimpleTrigger更常用
 *
 * Cron表达式（看看CronTable）
 *
 *用于配置CronTrigger实例。
 * 是由7个子表达式组成的字符串，描述了时间表的详细信息。
 * 格式:[秒][分][小时][日][月][周][年]
 *
 *Seconds:可出现", - * /"四个字符，有效范围为0-59的整数
 *Minutes:可出现", - * /"四个字符，有效范围为0-59的整数
 *Hours:可出现", - * /"四个字符，有效范围为0-23的整数
 *DayofMonth:可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
 *Month:可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
 *DayofWeek:可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
 *Year:可出现", - * /"四个字符，有效范围为1970-2099年
 *
 *每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是
 *
 *  1. *：表示匹配该域的任意值，假如在Minutes域使用*, 即表示每分钟都会触发事件。
 *  2. ?:只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。
 *   因为DayofMonth和 DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，
 *   则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，
 *   实际上并不是这样。
 *  3. -:表示范围，例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
 *  4. /：表示起始时间开始触发，然后每隔固定时间触发一次，例如在Minutes域使用5/20,则意味着从5分钟开始，
 *     每20触发一次.
 *  5. ,:表示列出枚举值值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
 *  6. L:表示最后，只能出现在DayofWeek和DayofMonth域，如果在DayofWeek域使用5L,意味着在最后的一个星期四触发
 *  7. W: 表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。
 *     例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：
 *     星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一 到星期五中的一天，
 *     则就在5日触发。另外一点，W的最近寻找不会跨过月份
 *   8. LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五
 *   9. #:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。
 *
 *  举几个例子:
 *    0 0 2 1 * ? * 表示在每月的1日的凌晨2点调度任务
 *    0 15 10 ? * MON-FRI 表示周一到周五每天上午10：15执行作业
 *    0 15 10 ? 6L 2002-2006 表示2002-2006年的每个月的最后一个星期五上午10:15执行作
 *
 *    其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?

 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
 0 0 12 ? * WED 表示每个星期三中午12点
 "0 0 12 * * ?" 每天中午12点触发
 "0 15 10 ? * *" 每天上午10:15触发
 "0 15 10 * * ?" 每天上午10:15触发
 "0 15 10 * * ? *" 每天上午10:15触发
 "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 "0 15 10 15 * ?" 每月15日上午10:15触发
 "0 15 10 L * ?" 每月最后一日的上午10:15触发
 "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发

 有些子表达式能包含一些范围或列表

 例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”

 “*”字符代表所有可能的值

 因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天


 “/”字符用来指定数值的增量
 例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
 在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样


 “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
 当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”

 “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
 但是它在两个子表达式里的含义是不同的。
 在天（月）子表达式中，“L”表示一个月的最后一天
 在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT

 如果在“L”前有具体的内容，它就具有其他的含义了

 例如：“6L”表示这个月的倒数第６天，“FRIL”表示这个月的最一个星期五
 注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题

 字段 允许值 允许的特殊字符
 秒 0-59 , - * /
 分 0-59 , - * /
 小时 0-23 , - * /
 日期 1-31 , - * ? / L W C
 月份 1-12 或者 JAN-DEC , - * /
 星期 1-7 或者 SUN-SAT , - * ? / L C #
 年（可选） 留空, 1970-2099 , - * /

 */

/**
 * StdSchedulerFactory
 *
 * 使用一组参数Properties来创建和初始化Quartz调度器
 * 配置参数一般存储在quartz.properties中
 *
 */
