package com.example.fx_5_codealong;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;

public class MirrorController
{
    @FXML private ImageView mirror_img;
    @FXML private StackPane frame_pane;
    @FXML private HBox thumbs_hbox;
    @FXML private CheckBox preserve_chk, smooth_chk, flip_chk, grayscale_chk;
    @FXML private Slider rotate_slider, opacity_slider;
    @FXML private Label rotate_lbl, opacity_lbl, vision_lbl, status_lbl;

    private static final String[] IMAGE_FILES = {
            "mirror_basin.png", "one_ring.png", "misty_mountains.png",
            "mallorn_tree.png", "shire_door.png"
    };
    private static final String[] IMAGE_TITLES = {
            "The Mirror", "The One Ring", "The Misty Mountains",
            "A Mallorn of Lórien", "A Door in the Shire"
    };

    /** Space between the frame's edge and the image (CSS padding + border, both sides). */
    private static final double FRAME_INSET = 2 * (14 + 2);

    private final Button[] thumbButtons = new Button[IMAGE_FILES.length];
    private final ColorAdjust grayscale = new ColorAdjust();

    public void initialize() {

        // STEP 7 (slides 14, 20) — build the thumbnail strip, then show the first vision.
        buildThumbnailStrip();
        showVision(0);
    }

    //region Loading Images
    private Image loadImage(String path)
    {
        return null;
    }
    //endregion

    //region Thumbnails
    private Image loadThumbnail(String path, double size)
    {

        return null;
    }
    /** Loops over the vision list and adds one image Button per vision. */
    private void buildThumbnailStrip()
    {

    }
    //endregion

    private void showVision(int index)
    {

    }
    public void handlePreserveRatio()
    {

    }
    public void handleSmooth()
    {

    }
    public void handleFlip()
    {

    }
    public void handleGrayscale()
    {

    }
    public void handleReset()
    {

    }

    /**
     * BUG ON PURPOSE: this path has no leading slash, so Java looks for
     *     /com/example/fx_5_codealong/images/palantir.png   (next to this class)
     * instead of
     *     /images/palantir.png                              (the resources root)
     *
     * Click the button and the null guard shows a warning instead of crashing.
     * Then fix it live by adding the leading "/" and run again.
     */
    public void handleLostVision()
    {
        Image lost = loadImage("images/palantir.png");
        if (lost == null) {
            setStatus("Some visions are lost... check the path!", true);
            return;
        }
        mirror_img.setImage(lost);
        vision_lbl.setText("A Palantír  ·  " + (int) lost.getWidth() + " × " + (int) lost.getHeight() + " px");
        setStatus("The seeing-stone answers. Path fixed!", false);
    }

    /** Swap style classes rather than inline colors, same as the Registration Form. */
    private void setStatus(String message, boolean isError)
    {
        status_lbl.setText(message);
        status_lbl.getStyleClass().removeAll("status-success", "status-error");
        status_lbl.getStyleClass().add(isError ? "status-error" : "status-success");
    }
}