package _4_class_obj.exercise.e2;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date endTime;

    public StopWatch(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date start() {
        return this.startTime = new Date();
    }

    public Date stop() {
        return this.endTime = new Date();
    }

//    public Date getElapsedTime() {
//
//    }

    public static void main(String[] args) {
        Date startTime = new Date();
        Date endTime = new Date();
        StopWatch stopWatch = new StopWatch(startTime, endTime);
    }

}
