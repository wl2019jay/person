<template>
    <div>
     	<head-top></head-top>
        <el-steps :active="active"  align-center>
            <el-step title="基本信息" icon="el-icon-edit" description="维护员工的基本信息">
            </el-step>
            <el-step title="身份信息" icon="el-icon-upload" description="上传员工的身份证正反面"></el-step>
            <el-step title="银行卡信息" icon="el-icon-upload" description="上传员工的银行信息"></el-step>
            <el-step title="经济人管理" icon="el-icon-picture" ></el-step>
        </el-steps>
        <el-form ref="form" :model="employees" label-width="80px" align-center >
            <div class="info" v-if="active==1" style="padding-left:20%" >
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="员工编码" label-width="100px"> 
                            <el-input v-model="employees.employeeCode"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="员工名称" label-width="100px"> 
                            <el-input v-model="employees.name"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="电话号码" label-width="100px"> 
                            <el-input v-model="employees.phone"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="电子邮箱" label-width="100px"> 
                            <el-input v-model="employees.email"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="性别" label-width="100px"> 
                            <el-radio-group v-model="employees.sex">
                                <el-radio label="F">男</el-radio>
                                <el-radio label="W">女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="所在城市" label-width="100px"> 
                            <el-input v-model="employees.cityName"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="详细地址" label-width="100px"> 
                            <el-input v-model="employees.address"  ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                 
            </div>

            <div v-if="active==2" class="info"  style="padding-left:5%">
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="身份证正面" label-width="200px">
                           <el-upload
                                class="avatar-uploader"
                                action=""
                                ref="uploadAvatar"
                                :show-file-list="false"
                                :auto-upload="false"
                                :on-change="changeFrontFile">
                            <img v-if="employees.idNum.frontImage" :src="employees.idNum.frontImage" width="300px" height="200px" class="uploadAvatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                         </el-upload>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="身份证反面" label-width="200px">
                            <el-upload
                                class="avatar-uploader"
                                action=""
                                ref="uploadAvatar1"
                                :show-file-list="false"
                                :auto-upload="false"
                                :on-change="changebackFile">
                            <img v-if="employees.idNum.backImage" :src="employees.idNum.backImage" width="300px" height="200px" class="uploadAvatar1">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                             </el-upload>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div style="padding-left:10%">
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="100px" label="姓名">
                                <el-input v-model="employees.idNum.name"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="100px" label="身份证号">
                                <el-input v-model="employees.idNum.idNum"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="15">
                            <el-form-item label-width="100px" label="身份证地址">
                                <el-input v-model="employees.idNum.address"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </el-form>
        <div style="padding-left:30%">
            <el-button style="margin-top: 12px;" @click="last" v-if="active>1" align-center>上一步</el-button>
            <el-button style="margin-top: 12px;" @click="next" v-if="active<4" align-center>下一步</el-button>
        </div>
    </div>
</template>
[]
<script>
 	import headTop from '@/components/headTop'
    import {valideIdCard, addCategory, addFood} from '@/api/getData'
    import {baseUrl, baseImgPath} from '@/config/env'
    export default {
    	data(){
    		return {
                active:'1',
                employees:{
                            sex:'F', 
                            idNum:{
                               frontImage:'',
                               backImage:''
                            }
                           }
    		}
    	},
    	components: {
    		headTop,
    	},
    	created(){
    		
    		this.initData();
    	},
    	computed: {
    		
    	},
    	methods: {
    		async initData(){
    			
            },
            next() {
                if (this.active++ > 3) this.active = 1;
            },
            last() {
                if (this.active-- < 3) this.active = 1;
            },
             changeFrontFile(file, fileList) {
                const isJPGORPNG = (file.raw.type === 'image/jpeg' || file.raw.type === 'image/png');
                const isLt1M = file.size / 1024 / 1024 < 1;
                debugger;
                if (!isJPGORPNG) {
                    this.$message.info('上传头像图片只能是 JPG 或 PNG 格式!');
                    return;
                }
                if (!isLt1M) {
                    this.$message.info('上传头像图片大小不能超过 1MB!');
                    return;
                }

                var This = this;
                var reader = new FileReader();
                reader.readAsDataURL(file.raw);
                reader.onload = function(e){
                    this.result; //base64编码
                    debugger;
                    This.employees.idNum.frontImage = this.result;
                }
            },
             changebackFile(file, fileList) {
                const isJPGORPNG = (file.raw.type === 'image/jpeg' || file.raw.type === 'image/png');
                const isLt1M = file.size / 1024 / 1024 < 1;

                if (!isJPGORPNG) {
                    this.$message.info('上传头像图片只能是 JPG 或 PNG 格式!');
                    return;
                }
                if (!isLt1M) {
                    this.$message.info('上传头像图片大小不能超过 1MB!');
                    return;
                }

                var This = this;
                var reader = new FileReader();
                reader.readAsDataURL(file.raw);
                reader.onload = function(e){
                    this.result; //base64编码
                    this.imageBaseUrl = this.result;
                    This.employees.idNum.backImage = this.result;
                    This.valideIdCard('dd');
                }
            },
            async valideIdCard(item1){
                let result = await valideIdCard(this.employees.idNum);
                this.employees.idNum=result;
            }

		}
    }
</script>

