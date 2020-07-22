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
                  property="userName"
                  label="用户名"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="phone"
                  label="电话号码"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="email"
                  label="邮件地址">
                </el-table-column>
                <el-table-column
                  property="remark"
                  label="备注">
                </el-table-column>
                <el-table-column
                  property="tip"
                  label="问题提示">
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
        <el-dialog title="新增用户" :visible="dialogFormVisible">
                <el-form :model="userinfo" :rules="rules" ref="userinfo">
                    <el-form-item label="用户名" label-width="100px" prop="userName">
                        <el-input v-model="userinfo.userName" auto-complete="off"></el-input>
                    </el-form-item>
                  
                    <el-form-item label="用户密码" label-width="100px" prop="password">
                        <el-input v-model="userinfo.password"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话" label-width="100px" prop="phone">
                        <el-input v-model="userinfo.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" label-width="100px" prop="email">
                        <el-input v-model="userinfo.email"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" label-width="100px">
                        <el-input v-model="userinfo.remark"></el-input>
                    </el-form-item>
                    <el-form-item label="问题提示" label-width="100px">
                        <el-input v-model="userinfo.tip"></el-input>
                    </el-form-item>
                </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="submiForm('userinfo')">确 定</el-button>
              </div>
            </el-dialog>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {getUserList, addUser} from '@/api/getData'
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
                  registe_time: '2016-05-02',
                  username: '王小虎',
                  city: '上海市普陀区金沙江路 1518 弄'
                }, {
                  registe_time: '2016-05-04',
                  username: '王小虎',
                  city: '上海市普陀区金沙江路 1517 弄'
                }, {
                  registe_time: '2016-05-01',
                  username: '王小虎',
                  city: '上海市普陀区金沙江路 1519 弄'
                }, {
                  registe_time: '2016-05-03',
                  username: '王小虎',
                  city: '上海市普陀区金沙江路 1516 弄'
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                currentPage: 1,
                userinfo: {
                    userName:'',
                    password:'Jc@2020'
                },
                dialogFormVisible:false, 
                rules:{
                    userName:[
                        {required:true,message:'用户名不能为空', trigger: 'blur'},
                        {validator:validUserName,trigger:'blur'}
                    ],
                    password:[
                       {required:true,message:'密码不能为空', trigger: 'blur'},
                       {validator:validPassward,trigger:'blur'}
                    ],
                     phone:[
                       {required:true,message:'手机号码不能为空', trigger: 'blur'},
                       {validator:validPhone,trigger:'blur'}
                    ],
                     email:[
                       {required:true,message:'邮箱不能为空', trigger: 'blur'},
                       {validator:validEmail,trigger:'blur'}
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
                    this.getUsers();
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
                this.getUsers()
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
                       let result = await addUser(this.userinfo);
                       if(result.code == '0000'){
                           this.$message({
					           type: 'success',
					           message: '添加成功'
                           });
                          this.userinfo= {
                                userName:'',
                                password:'Jc@2020'
                          };
                          this.getUsers();
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
            async getUsers(){
                const Users = await getUserList({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Users.forEach(item => {
                    const tableData = {};
                    tableData.userName = item.userName;
                    tableData.phone = item.phone;
                    tableData.email = item.email;
                    tableData.remark = item.remark;
                    tableData.tip = item.tip;
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
