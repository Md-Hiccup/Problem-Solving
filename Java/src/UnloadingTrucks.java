/**
 * Created by dastaniqbal on 21/08/2019.
 * ask2iqbal@gmail.com
 * 21/08/2019 11:28
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class UnloadingTrucks {
    static boolean result = false;

    public static Boolean canUnloadAll(Collection<UnloadingTime> unloadingTimes) {

        ArrayList<UnloadingTime> unloadingTimeList = new ArrayList<>(unloadingTimes);
        unloadingTimes.forEach(unloadingTime1 -> unloadingTimeList.forEach(unloadingTime2 -> {
            if (unloadingTime1 != unloadingTime2) {
                if (unloadingTime2.getStart().after(unloadingTime1.getStart()) &&
                        unloadingTime2.getStart().before(unloadingTime1.getEnd())) {
                    result = false;
                }else if (unloadingTime2.getEnd().after(unloadingTime1.getStart()) &&
                        unloadingTime2.getStart().before(unloadingTime1.getEnd())) {
                    result = false;
                } else {
                    result = true;
                }
            }
        }));
        return result;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<UnloadingTime> unloadingTimes = new ArrayList<UnloadingTime>();
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 19:00"), sdf.parse("03/04/2019 20:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 22:10"), sdf.parse("03/04/2019 22:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 19:30"), sdf.parse("03/04/2019 22:00")));

        System.out.println(UnloadingTrucks.canUnloadAll(unloadingTimes));
    }
}

class UnloadingTime {
    private Date start, end;

    public UnloadingTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}
