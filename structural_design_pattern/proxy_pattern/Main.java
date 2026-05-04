package structural_design_pattern.proxy_pattern;

import java.util.*;
interface VideoStreaming{
    public void playVideo(String videoName , String userType);
}

class VideoServer implements VideoStreaming{

    @Override
    public void playVideo(String videoName,String userType){
        System.out.println("Loading video: " + videoName + " from the server.......");
        System.out.println("Playing video: "+videoName+" from the server.....");
    }
}

class VideoServerProxy implements VideoStreaming{
    protected VideoServer videoServer;

    private List<String>cachedVideos = new ArrayList<>();

    @Override
    public void playVideo(String videoName , String userType){
        //1. access control
        if(userType.equals("free")){
            System.out.println("Free users not allowed! Please start a premium plan with Rs.199 per month.");
            return;
        }

        //2.caching service
        if(cachedVideos.contains(videoName)){
            System.out.println("Playing video: "+videoName+" from the cache! No server call needed");
            return;
        }
        if(videoServer == null) videoServer = new VideoServer();
        videoServer.playVideo(videoName,userType);
        cachedVideos.add(videoName);

        //3. logging
        System.out.println("Usertype: "+userType+" Watching video: "+videoName);

    }
}
public class Main {
    public static void main(String[] args) {
        VideoStreaming netflix = new VideoServerProxy();

        netflix.playVideo("KGF" , "free");
        netflix.playVideo("KGF","Premium");
        netflix.playVideo("KGF2","Premium");
        netflix.playVideo("KGF","Premium");
        netflix.playVideo("KGF2","Premium");
        netflix.playVideo("KGF","Premium");

    }
}
