package com.jc.person.util;

import com.jc.person.vo.EmployeeIdCardVO;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;

public class IDCardDetect {
//    @Value("${q_appid}")
    private static String appId="1301377239";
  //  @Value("${q_SecretId}")
    private static String secretId="AKIDtbkpmUXDeqna7QHKwJRJxLYWGl12eWw7";
    //@Value("${q_SecretKey}")
    private static String secretKey="6yf7TebJXWHm2B9sMccOuAAwUnqdDXcU";
    private static  String  bucketName="jcbucket";

    public static EmployeeIdCardVO detect( String frontImage,String backImage){
        try{

            Credential cred = new Credential(secretId, secretKey);

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-guangzhou", clientProfile);
            IDCardOCRRequest request=new IDCardOCRRequest();
            request.setCardSide("FRONT");
            request.setImageBase64(frontImage);

            IDCardOCRResponse resp = client.IDCardOCR(request);
            EmployeeIdCardVO result=new EmployeeIdCardVO();
            result.setAddress(resp.getAddress());
            result.setBirth(resp.getBirth());
            result.setIdNum(resp.getIdNum());
            result.setName(resp.getName());
            result.setNation(resp.getNation());
            result.setSex(resp.getSex());
            result.setValidDate(resp.getValidDate());

            System.out.println(IDCardOCRRequest.toJsonString(resp));
            return result;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
