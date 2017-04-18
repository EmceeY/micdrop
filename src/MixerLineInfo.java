import javax.sound.sampled.*;


/**
 * Created by mcoreyyares on 4/14/17.
 */

public class MixerLineInfo {
    public static void main(String[] args) throws LineUnavailableException {
        Mixer.Info[] mInfo = AudioSystem.getMixerInfo();
        for (Mixer.Info info : mInfo) {
            System.out.println("info: " + info);
            Mixer mixer1 = AudioSystem.getMixer(info);
            System.out.println("mixer " + mixer1);
            Line.Info[] sl = mixer1.getSourceLineInfo();
            for (Line.Info info2 : sl){
                System.out.println("    info: " + info2);
                Line line = AudioSystem.getLine(info2);
                if (line instanceof SourceDataLine){
                    SourceDataLine source = (SourceDataLine) line;

                    DataLine.Info i = (DataLine.Info) source.getLineInfo();
                    for (AudioFormat format : i.getFormats()){
                        System.out.println("    format: " + format);
                    }
                }
            }

        }
    }
}
