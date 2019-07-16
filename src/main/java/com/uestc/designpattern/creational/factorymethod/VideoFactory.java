package com.uestc.designpattern.creational.factorymethod;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 09:02
 */
public abstract class VideoFactory {

    public abstract Video getVideo();
//    public Video getVideo(String type) {
//        if ("java".equalsIgnoreCase(type)) {
//            return new JavaVideo();
//        } else if ("python".equalsIgnoreCase(type)) {
//            return new PythonVideo();
//        } else {
//            return null;
//        }
//    }
//    public Video getVideo(Class cls) {
//        Video video = null;
//
//        try {
//            video = (Video) Class.forName(cls.getName()).newInstance();
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }

}
