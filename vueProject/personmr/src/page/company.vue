<template>
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <el-row>
                <el-tooltip class="item" effect="dark" content="新增" placement="top-start">
                    <el-button type="info"  @click="handleEdit(1)"  icon="el-icon-plus" circle></el-button>
                </el-tooltip>
                <el-tooltip class="item" effect="dark" content="冻结" placement="top">
                    <el-button type="warning" icon="el-icon-lock" circle></el-button>
                </el-tooltip>
                 <el-tooltip class="item" effect="dark" content="删除" placement="top-end">
                    <el-button type="danger" icon="el-icon-delete" circle></el-button>
                 </el-tooltip>
            </el-row>
            <el-table
                :data="tableData"
                highlight-current-row
                style="width: 100%">
                <el-table-column
                  type="index"
                  width="100">
                </el-table-column>
                <el-table-column
                  property="companyCode"
                  label="公司编码"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="companyName"
                  label="公司名称"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="companyDesc"
                  label="公司描述">
                </el-table-column>
                <el-table-column
                  property="address"
                  label="地址">
                </el-table-column>
                <el-table-column
                  property="tellPhone"
                  label="联系电话">
                </el-table-column>
                <el-table-column
                  property="ostModeId"
                  label="计费方式">
                </el-table-column>
            </el-table>
            <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="currentPage"
                  :page-size="20"
                  layout="total, prev, pager, next"
                  :total="count">
                </el-pagination>
            </div>
            
        </div>
        <el-dialog title="新增公司" :visible="dialogFormVisible">
                <el-form :model="conpanyInfo" :rules="rules" ref="conpanyInfo">
                    <el-form-item label="公司编码" label-width="100px" prop="companyCode">
                        <el-input v-model="conpanyInfo.companyCode" auto-complete="off"></el-input>
                    </el-form-item>
                  
                    <el-form-item label="公司名称" label-width="100px" prop="companyName">
                        <el-input v-model="conpanyInfo.companyName"></el-input>
                    </el-form-item>
                    <el-form-item label="公司描述" label-width="100px" prop="companyDesc">
                        <el-input v-model="conpanyInfo.companyDesc"></el-input>
                    </el-form-item>
                    <el-form-item label="公司地址" label-width="100px" prop="address">
                        <el-input v-model="conpanyInfo.address"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话" label-width="100px" prop="tellPhone">
                        <el-input v-model="conpanyInfo.tellPhone"></el-input>
                    </el-form-item>
                    <el-form-item label="计费方式" label-width="100px">
                        <el-input v-model="conpanyInfo.ostModeId"></el-input>
                    </el-form-item>
                    <el-form-item label="宣全照片" label-width="100px">
                        <el-upload
                                class="avatar-uploader"
                                action=""
                                ref="uploadAvatar"
                                :show-file-list="false"
                                :auto-upload="false"
                                :on-change="changeFile">
                            <img v-if="conpanyInfo.image" :src="conpanyInfo.image" width="300px" height="200px" class="uploadAvatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                    </el-form-item>
                </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="submiForm('conpanyInfo')">确 定</el-button>
              </div>
            </el-dialog>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {addCompany, queryCompany,queryCompanyCount,updateCompany} from '@/api/getData'
    export default {
        data(){
            // 用户名称
            let validUserName=(rule,value,callback)=>{
                let reg=/^[a-zA-Z0-9_-]{4,16}$/
                if(!reg.test(value)){callback(new Error('账号必须是由4-16位数字、字母、下划线和减号组合'))
                }else{
                    callback()
                }
            };
            // 用户密码
            let validPassward=(rule,value,callback)=>{
                let reg=/^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/
                if(!reg.test(value)){callback(new Error('密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符'))
                }else{
                    callback()
                }
            };
            // 电话号码
            let validPhone=(rule,value,callback)=>{
                let reg=/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/
                if(!reg.test(value)){callback(new Error('手机号码不正确'))
                }else{
                    callback()
                }
            };
            // 邮箱
            let validEmail=(rule,value,callback)=>{
                let reg=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
                if(!reg.test(value)){callback(new Error('邮箱格式不正确 eg:1234567@qq.com'))
                }else{
                    callback()
                }
            };
            return {
                tableData: [{
                  companyCode: '2016-05-02',
                  companyName: '王小虎',
                  companyDesc: '上海市普陀区金沙江路 1518 弄'
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                currentPage: 1,
                conpanyInfo: {
                    companyCode:'',
                    companyName:'',
                    companyDesc:'',
                    image:'',
                    address:'',
                    tellPhone:'',
                    ostModeId:''
                },
                dialogFormVisible:false, 
                rules:{
                    companyCode:[
                        {required:true,message:'公司编码不能为空', trigger: 'blur'}
                    ],
                    companyName:[
                       {required:true,message:'公司名称不能为空', trigger: 'blur'}
                    ],
                     tellPhone:[
                       {required:true,message:'手机号码不能为空', trigger: 'blur'},
                       {validator:validPhone,trigger:'blur'}
                    ],
                     companyDesc:[
                       {required:true,message:'公司描述不能为空', trigger: 'blur'}
                    ],
                     address:[
                       {required:true,message:'地址不能为空', trigger: 'blur'}
                    ]
                }
            }
        },
    	components: {
    		headTop,
    	},
        created(){
            this.initData();
        },
        methods: {
            async initData(){
                try{
                    // const countData = await getUserCount();
                    // if (countData.status == 1) {
                    //     this.count = countData.count;
                    // }else{
                    //     throw new Error('获取数据失败');
                    // }
                    this.queryCompany();
                }catch(err){
                    console.log('获取数据失败', err);
                }
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.queryCompany()
            },
             handleEdit(flag) {
                 debugger;
               // this.selectTable = row;
                //this.address.address = row.address;
                this.dialogFormVisible = true;
               // this.selectedCategory = row.category.split('/');
               // if (!this.categoryOptions.length) {
                //    this.getCategory();
               // }
            },
            submiForm(formName){
               this.$refs[formName].validate(async (valid) => {
                   if(valid)
                   {
                       let result = await addCompany(this.conpanyInfo);
                       if(result.code == '0000'){
                           this.$message({
					           type: 'success',
					           message: '添加成功'
                           });
                          this.conpanyInfo= {
                                companyCode:'',
                                companyName:'',
                                companyDesc:'',
                                image:'',
                                address:'',
                                tellPhone:'',
                                ostModeId:''
                          };
                          this.queryCompany();
                          this.dialogFormVisible=false;
                       }
                       debugger
                   } else {
						this.$notify.error({
							title: '错误',
							message: '请检查输入是否正确',
							offset: 100
						});
						return false;
					}
               });
            },
            changeFile(file, fileList) {
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
                    This.imageBaseUrl = this.result;
                    This.conpanyInfo.image = this.result;
                }
            },
            async queryCompany(){
                const Companys = await queryCompany({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Companys.forEach(item => {
                    const tableData = {};
                    tableData.companyCode = item.companyCode;
                    tableData.companyName = item.companyName;
                    tableData.companyDesc = item.companyDesc;
                    tableData.image = item.image;
                    tableData.address = item.address;
                    tableData.tellPhone = item.tellPhone;
                    tableData.ostModeId = item.ostModeId;
                    tableData.pid = item.pid;
                    this.tableData.push(tableData);
                })
            }
        },
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
</style>
