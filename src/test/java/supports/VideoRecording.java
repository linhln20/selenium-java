//package supports;
//
//import org.monte.media.Format;
//import org.monte.media.FormatKeys;
//import org.monte.media.math.Rational;
//import org.monte.screenrecorder.ScreenRecorder;
//import java.awt.*;
//import java.io.File;
//import static org.monte.media.VideoFormatKeys.*;
//
//public class VideoRecorder {
//    private static ScreenRecorder screenRecorder;
//
//    public static void startRecording() throws Exception {
//        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                .getDefaultScreenDevice()
//                .getDefaultConfiguration();
//
//        screenRecorder = new ScreenRecorder(
//                gc,
//                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
//                new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
//                        new Rational(15, 1), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
//                new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, "black",
//                        FrameRateKey, new Rational(30, 1)),
//                null,
//                new File("./recordings/")
//        );
//
//        screenRecorder.start();
//    }
//
//    public static void stopRecording() throws Exception {
//        if (screenRecorder != null) {
//            screenRecorder.stop();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        startRecording();
//        Thread.sleep(5000); // Giả lập test tự động
//        stopRecording();
//    }
//}
