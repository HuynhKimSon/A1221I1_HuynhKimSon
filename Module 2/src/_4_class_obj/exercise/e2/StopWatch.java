package _4_class_obj.exercise.e2;


public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }


    public long getElapsedTime() {
        long milliseconds = this.endTime - this.startTime;
        return milliseconds;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Thoi gian bat dau : " + stopWatch.startTime);
        for (int i = 0; i < 100000000; i++) {
        }
        stopWatch.stop();
        System.out.println("Thoi gian ket thuc : " + stopWatch.endTime);
        System.out.println("Thoi gian thuc thi : " + stopWatch.getElapsedTime());
    }
}
