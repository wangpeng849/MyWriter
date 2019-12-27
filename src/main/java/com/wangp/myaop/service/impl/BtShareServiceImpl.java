package com.wangp.myaop.service.impl;

import com.wangp.myaop.service.BtShareService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class BtShareServiceImpl implements BtShareService {

    @Transactional
    @Override
    public int editMovieInfo(int id, MultipartFile file, String uploadDir) {
        try {
// 图片路径
            String imgUrl = null;
//上传
            String filename = upload(file, uploadDir, file.getOriginalFilename());
//            if (!EmptyUtil.isEmpty(filename)) {
//                imgUrl = new File(uploadDir).getName() + "/" + filename;
//            }
//            MovieInfo movie = movieInfoService.selectMovieInfoByDcpId(Integer.valueOf(movieDto.getId()));
//            movie.setImgUrl(imgUrl)
//            movieInfoService.updateMovieInfoByDcpId(movieInfo);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String upload(MultipartFile file, String path, String fileName) throws Exception {
// 生成新的文件名
        String realPath = path + "/" + UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
        File dest = new File(realPath);
// 判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
// 保存文件
        file.transferTo(dest);
        return dest.getName();
    }
}
