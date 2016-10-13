import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.controls.label.builder.LabelBuilder;
import de.lessvoid.nifty.nulldevice.NullSoundDevice;
import de.lessvoid.nifty.renderer.lwjgl.input.LwjglInputSystem;
import de.lessvoid.nifty.renderer.lwjgl.render.LwjglRenderDevice;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.tools.SizeValue;
import de.lessvoid.nifty.tools.TimeProvider;

public class NiftyTest extends StateBasedGame {

   class ScreenControllerExample implements ScreenController {
      public void bind(Nifty arg0, Screen arg1) {}
      public void onEndScreen() {}
      public void onStartScreen() {}
   }

   class MainMenuGameState extends BasicGameState {

      private Nifty nifty;

      public void init(GameContainer container, StateBasedGame game) throws SlickException {
         nifty = new Nifty(new LwjglRenderDevice(), new NullSoundDevice(), new LwjglInputSystem(), new TimeProvider());

         nifty.loadStyleFile("nifty-default-styles.xml");
         nifty.loadControlFile("nifty-default-controls.xml");

         Screen mainScreen = new ScreenBuilder("main") {{
            controller(new ScreenControllerExample());
            layer(new LayerBuilder("layer") {{
               backgroundColor("#003f");
               childLayoutCenter();
               panel(new PanelBuilder() {{
                  id("panel");
                  childLayoutCenter();
                   height(SizeValue.percent(25));
                   width(SizeValue.percent(80));
                  control(new LabelBuilder("mylabel") {{
                     text("Hello World");
                  }});
               }});
            }});
         }}.build(nifty);

         nifty.addScreen("mainScreen", mainScreen);
         nifty.gotoScreen("mainScreen");
      }

      public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
         nifty.update();
      }

      public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
         SlickCallable.enterSafeBlock();
         nifty.render(false);
         SlickCallable.leaveSafeBlock();
      }

      @Override
      public int getID() {
         return 0;
      }
   }

   public NiftyTest(String name) {
      super(name);
      addState(new MainMenuGameState());
   }

   public static void main(String[] args) throws SlickException {
      NiftyTest game = new NiftyTest("Nifty Slick Example");

      AppGameContainer app = new AppGameContainer(game);
      app.setDisplayMode(800, 600, false);
      app.setAlwaysRender(true);
      app.setFullscreen(false);
      app.setForceExit(true);
      app.start();
   }

   @Override
   public void initStatesList(GameContainer container) throws SlickException {

   }

}