package prob; /**
 * Created by dastaniqbal on 21/08/2019.
 * ask2iqbal@gmail.com
 * 21/08/2019 11:09
 */

import java.util.concurrent.Callable;

interface Bird {
    Egg Lay();
}

class Chicken implements Bird{
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
    }

    @Override
    public Egg Lay() {
        return new Egg(Chicken::new);
    }
}

class Egg {

    private Callable<Bird> createBird;
    boolean isHatched = false;

    public Egg(Callable<Bird> createBird) {
        this.createBird = createBird;
    }

    public Bird Hatch() throws Exception {
        if(isHatched) throw new IllegalStateException("egg hatched");
        isHatched = true;
        return createBird.call();
    }
}