package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by donovan on 15/05/29.
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {


    private String title = "Sgt. Peppers";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
