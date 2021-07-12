package com.flyingblock.pcm.animation;import com.flyingblock.pcm.animation.Animation.ImageAnimationType;import com.flyingblock.pcm.animation.Animation.StringAnimationType;import com.flyingblock.pcm.borrowed.GifDecoder;import com.flyingblock.pcm.tags.Alignment;import com.flyingblock.pcm.tags.ColorTag;import com.flyingblock.pcm.tags.DateTag;import com.flyingblock.pcm.tags.Format;import com.flyingblock.pcm.tags.PlayerTags;import com.flyingblock.pcm.tags.Tag;import com.flyingblock.pcm.tags.UnicodeTag;import com.flyingblock.pcm.tags.after.AfterTag;import com.flyingblock.pcm.tags.after.PlayerAfterTag;import java.awt.image.BufferedImage;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import java.io.InputStream;import java.io.OutputStream;import java.util.ArrayList;import java.util.Arrays;import java.util.List;import java.util.logging.Level;import java.util.logging.Logger;import javax.imageio.ImageIO;import net.md_5.bungee.api.ChatColor;import net.md_5.bungee.api.plugin.Plugin;public class PingAnimationSave{    private final Tag[] tags = {        new ColorTag('&'),        new UnicodeTag(),        new PlayerTags(),        new DateTag()    };        private final AfterTag[] afterTags = {        new PlayerAfterTag()    };    private final Format[] playerFormats = {        new Alignment()    };        private int length;        private Plugin plugin;        private List<String> pStrings;    private List<StringAnimationType> pType;    private List<Integer> pInterval;    private List<Integer> pLoops;    private int playerFrameSize;        private List<String> mStrings;    private List<StringAnimationType> mType;    private List<Integer> mInterval;    private List<Integer> mLoops;    private int motdFrameSize;        private String vString;    private StringAnimationType vType;    private int vInterval;    private int vLoops;    private int versionFrameSize;        private String imageFile;        private List<BufferedImage> images;    private ImageAnimationType iType;    private int iInterval;    private int iLoops;        public PingAnimationSave(        List<String> pStrings, List<StringAnimationType> pType, List<Integer> pInterval, List<Integer> pLoops,        List<String> mStrings, List<StringAnimationType> mType, List<Integer> mInterval, List<Integer> mLoops,        String vString, StringAnimationType vType, int vInterval, int vLoops,        String imageFile, ImageAnimationType iType, int iInterval, int iLoops,         int length, int playerFrameSize, int motdFrameSize, int versionFrameSize, Plugin plugin)    {        this.plugin = plugin;                this.pStrings = pStrings;        this.pType = pType;        this.pInterval = pInterval;        this.pLoops = pLoops;                this.mStrings = mStrings;        this.mType = mType;        this.mInterval = mInterval;        this.mLoops = mLoops;                this.vString = vString;        this.vType = vType;        this.vInterval = vInterval;        this.vLoops = vLoops;                this.imageFile = imageFile;        this.iType = iType;        this.iInterval = iInterval;        this.iLoops = iLoops;                this.length = length;        this.playerFrameSize = playerFrameSize;        this.motdFrameSize = motdFrameSize;        this.versionFrameSize = versionFrameSize;                this.updateImage();        develop("");    }        public PingAnimation develop(String player)    {        List<String> players = new ArrayList<>(pStrings);        List<Integer> pInterval = new ArrayList<>(this.pInterval);        List<Integer> pLoops = new ArrayList<>(this.pLoops);        List<StringAnimationType> pType = new ArrayList<>(this.pType);        List<String> motds = new ArrayList<>(mStrings);        String version = vString;                for(int index = 0; index < players.size(); index++)        {            for(AfterTag a : afterTags)            {                String line = players.get(index);                if(line != null && a.containsTarget(line))                {                    if(a.removeLine(line))                        players.set(index, null);                    else if(a.containsTarget(line))                        players.set(index, a.applyTo(line, player));                }            }            for(Tag t : tags) {                String line = players.get(index);                if(line != null && t.containsTarget(line))                {                    if(t.removeLine(line))                        players.set(index, null);                    else if(t.containsTarget(line))                        players.set(index, t.applyTo(line));                }            }        }        int indexPlayer = 0;        while(indexPlayer < players.size())        {            if(players.get(indexPlayer) == null)            {                pInterval.remove(indexPlayer);                pLoops.remove(indexPlayer);                pType.remove(indexPlayer);                players.remove(indexPlayer);            }            else                indexPlayer++;        }                for(int index = 0; index < motds.size(); index++)        {            String line = motds.get(index);            for(AfterTag a : afterTags)            {                if(a.containsTarget(line))                {                      line = a.applyTo(line, player);                }            }            for(Tag t : tags) {                if(t.containsTarget(line))                {                    if(!t.removeLine(line))                        line = t.applyTo(line);                    else                        line = t.stripTags(line);                }            }            motds.set(index, line);        }                for(Tag t : tags) {            if(t.containsTarget(version))            {                if(!t.removeLine(version))                    version = t.applyTo(version);                else                    version = t.stripTags(version);            }            t.reset();        }        for(AfterTag a : afterTags)        {            if(a.containsTarget(version))            {                if(!a.removeLine(version))                    version = a.applyTo(version, player);                else                    version = a.stripTags(version);            }            a.reset();        }                Animation<BufferedImage> imageAnim = new Animation<>(images.toArray(new BufferedImage[images.size()]), iInterval, iLoops);                for(Format f : playerFormats) {            players = new ArrayList<String>(Arrays.asList(f.format(players.toArray(new String[players.size()]))));            f.reset();        }                List<Animation<String>> playerAnims = new ArrayList<>();        for(int i = 0; i < players.size(); i++) {            playerAnims.add(Animation.developAnimation(pType.get(i), players.get(i), playerFrameSize, pInterval.get(i), pLoops.get(i)));        }        int playersInterval = playerAnims.get(0).getInterval();        for(int index = 0; index < playerAnims.size(); index++)            if(playerAnims.get(index).getInterval() < playersInterval)                playersInterval = playerAnims.get(index).getInterval();        int playersLoops = 1;        boolean playersBounded = true;        for(Animation<?> a : playerAnims)            if(playersBounded && !a.isBounded())                playersBounded = false;        if(!playersBounded)            playersLoops = -1;                List<Animation<String>> motdAnims = new ArrayList<>();        for(int i = 0; i < motds.size(); i++) {            motdAnims.add(Animation.developAnimation(mType.get(i), motds.get(i), motdFrameSize, mInterval.get(i), mLoops.get(i)));        }        int motdInterval = motdAnims.get(0).getInterval();        for(int index = 0; index < motdAnims.size(); index++)            if(motdAnims.get(index).getInterval() < motdInterval)                motdInterval = motdAnims.get(index).getInterval();        int motdLoops = 1;        boolean motdBounded = true;        for(Animation<?> a : motdAnims)            if(motdBounded && !a.isBounded())                motdBounded = false;        if(!motdBounded)            motdLoops = -1;                return new PingAnimation(                Animation.combineAnimations(playerAnims, playersInterval, playersLoops),                 imageAnim,                Animation.developAnimation(vType, version, versionFrameSize, vInterval, vLoops),                Animation.combineAnimations(motdAnims, motdInterval, motdLoops, ChatColor.RESET + "\n"),                getLength());    }        //start of players        public void addPlayer(String player, StringAnimationType type, int interval, int loops)    {        pStrings.add(player);        pType.add(type);        pInterval.add(interval);        pLoops.add(loops);    }        public void removePlayer(int line)    {        pStrings.remove(line);        pType.remove(line);        pInterval.remove(line);        pLoops.remove(line);    }        public void setPlayer(String player, StringAnimationType type, int line, int interval, int loops)    {        pStrings.set(line, player);        pType.set(line, type);        pInterval.set(line, interval);        pLoops.set(line, loops);    }        public void insertPlayer(String player, StringAnimationType type, int line, int interval, int loops)    {        pStrings.add(line, player);        pType.add(line, type);        pInterval.add(line, interval);        pLoops.add(line, loops);            }        public String getPlayer(int line)    {        return pStrings.get(line);    }        public StringAnimationType getPlayerType(int line)    {        return pType.get(line);    }        public int getPlayerInterval(int line)    {        return pInterval.get(line);    }        public int getPlayerLoops(int line)    {        return pLoops.get(line);    }        public int getPlayers()    {        return pStrings.size();    }        //start of motd        public void addMotdLine(String text, StringAnimationType type, int interval, int loops)    {        mStrings.add(text);        mType.add(type);        mInterval.add(interval);        mLoops.add(loops);    }        public void removeMotdLine(int line)    {        mStrings.remove(line);        mType.remove(line);        mInterval.remove(line);        mLoops.add(line);    }        public void setMotdLine(String text, StringAnimationType type, int interval, int loops, int line)    {        mStrings.set(line, text);        mType.set(line, type);        mInterval.set(line, interval);        mLoops.set(line, loops);    }        public void insertMotdLine(String text, StringAnimationType type, int interval, int loops, int line)    {        mStrings.add(line, text);        mType.add(line, type);        mInterval.add(line, interval);        mLoops.add(line, loops);    }        public String getMotdLine(int line)    {        return mStrings.get(line);    }        public StringAnimationType getMotdLineType(int line)    {        return mType.get(line);    }        public int getMotdInterval(int line)    {        return mInterval.get(line);    }        public int getMotdLoops(int line)    {        return mLoops.get(line);    }        public int getMotdLength()    {        return mStrings.size();    }        //start of version        public void setVersionName(String name)    {        vString = name;    }        public String getVersionName()    {        return vString;    }        public void setVersionType(StringAnimationType type)    {        vType = type;    }        public StringAnimationType getVersionType()    {        return vType;    }        public void setVersionInterval(int interval)    {        vInterval = interval;    }        public int getVersionInterval()    {        return vInterval;    }        public void setVersionLoops(int loops)    {        vLoops = loops;    }        public int getVersionLoops()    {        return vLoops;    }        //start of server-icon        public void setCompressedImages(List<BufferedImage> images)    {        this.images = images;    }        public List<BufferedImage> getCompressedImages()    {        return images;    }        public void setImageAnimation(ImageAnimationType type)    {        iType = type;    }        public ImageAnimationType getImageAnimation()    {        return iType;    }        public void setImageInterval(int interval)    {        this.iInterval = interval;    }        public int getImageInterval()    {        return iInterval;    }        public void setImageLoops(int loops)    {        iLoops = loops;    }        public int getImageLoops()    {        return iLoops;    }        public void setImagePath(String path)    {        this.imageFile = path;    }        public String getImagePath()    {        return imageFile;    }        /*public static CompressedImage[] readGif(File path)    {         CompressedImage[] images = null;        try {            ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();            ImageInputStream ciis = ImageIO.createImageInputStream(path);            reader.setInput(ciis, false);               int noi = reader.getNumImages(true);            BufferedImage plate = new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);            images = new CompressedImage[noi];            for (int i = 0; i < noi; i++) {                BufferedImage image = reader.read(i);                if(image.getWidth() != 64 || image.getHeight() != 64)                    image = toBufferedImage(reader.read(i).getScaledInstance(64, 64, Image.SCALE_FAST));                plate.getGraphics().drawImage(image, 0,0, null);                images[i] = CompressedImage.fromPng(image);            }        } catch (IOException e) {            e.printStackTrace();        }        return images;    }    /*    public static BufferedImage copyImage(BufferedImage source)    {        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());        Graphics g = b.getGraphics();        g.drawImage(source, 0, 0, null);        g.dispose();        return b;    }*/        /**    * Converts a given Image into a BufferedImage    *    * @param img The Image to be converted    * @return The converted BufferedImage    */    /*public static BufferedImage toBufferedImage(Image img)    {        if (img instanceof BufferedImage)        {            return (BufferedImage) img;        }        // Create a buffered image with transparency        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);        // Draw the image on to the buffered image        Graphics2D bGr = bimage.createGraphics();        bGr.drawImage(img, 0, 0, null);        bGr.dispose();        // Return the buffered image        return bimage;    }*/        public static void copyFile(InputStream in, File dest) throws IOException     {        if(!dest.exists()) {                dest.createNewFile();            }            OutputStream out = null;            try {                out = new FileOutputStream(dest);                // Transfer bytes from in to out                byte[] buf = new byte[1024];                int len;                while ((len = in.read(buf)) > 0) {                    out.write(buf, 0, len);                }            }            finally {                if(in != null) {                in.close();            }            if(out != null) {                out.close();            }        }    }        public final void updateImage()    {        File imageFile = new File(plugin.getDataFolder(), this.imageFile);        if(!imageFile.exists())        {            try {                copyFile(plugin.getResourceAsStream("server-icon.gif"), imageFile);            } catch (IOException ex) {                            }        }        switch(iType)        {            case GIF:            {                GifDecoder decoder = new GifDecoder();                try {                    decoder.read(new FileInputStream(imageFile));                } catch (FileNotFoundException ex) {                    Logger.getLogger(PingAnimationSave.class.getName()).log(Level.SEVERE, null, ex);                }                images = new ArrayList<>();                for(int i = 0; i < decoder.getFrameCount(); i++) {                    BufferedImage image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);                    image.getGraphics().drawImage(decoder.getFrame(i).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH), 0, 0, null);                    images.add(image);                }                break;            }            case PNG:            {                images = new ArrayList<>();                {                    try {                        BufferedImage image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);                        image.getGraphics().drawImage(ImageIO.read(imageFile).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH), 0, 0, null);                        images.add(image);                    } catch (IOException ex) {                        Logger.getLogger(PingAnimationSave.class.getName()).log(Level.SEVERE, null, ex);                    }                }                break;            }        }    }        public int getLength()    {        return length;    }        public void setLength(int length)    {        this.length = length;    }        public void setPlayerFrameSize(int playerFrameSize)    {        this.playerFrameSize = playerFrameSize;    }        public int getPlayerFrameSize()    {        return playerFrameSize;    }        public void setMotdFrameSize(int motdFrameSize)    {        this.motdFrameSize = motdFrameSize;    }        public int getMotdFrameSize()    {        return motdFrameSize;    }        public void setVersionFrameSize(int versionFrameSize)    {        this.versionFrameSize = versionFrameSize;    }        public int getVersionFrameSize()    {        return versionFrameSize;    }}