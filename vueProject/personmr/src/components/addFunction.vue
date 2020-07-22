<template>
    <div>
        <el-dialog
            title="编辑菜单"
            :visible.sync="visible"
            @close="closeDialog"
            :show="show">
            <el-form :model="functionInfo" :rules="rules" ref="functionInfo">
                    <el-form-item label="功能编码" label-width="100px" prop="functionCode">
                        <el-input v-model="functionInfo.functionCode" auto-complete="off"></el-input>
                    </el-form-item>
                  
                    <el-form-item label="功能名称" label-width="100px" prop="functionName">
                        <el-input v-model="functionInfo.functionName"></el-input>
                    </el-form-item>
                    <el-form-item label="功能地址" label-width="100px" prop="functionUrl">
                        <el-input v-model="functionInfo.functionUrl"></el-input>
                    </el-form-item>
                    <el-form-item label="是否有效" label-width="100px" prop="enableFlag">
                        <el-switch
                            v-model="functionInfo.enableFlag"
                            active-color="#1E90FF"
                            inactive-color="#D3D3D3">
                        </el-switch>
                    </el-form-item>
                   
                </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="closeDialog">取 消</el-button>
                <el-button type="primary" @click="sumbmitData('functionInfo')">确 定</el-button>
              </div>
        </el-dialog>

    </div>
</template>
 
<script>
    import {addFunction,queryById,updateFunction} from '@/api/getData'
    let id = 1000;
    export default {
        name:'addFunction',
        data () {
            
            return {
               functionInfo:{
                   functionCode:'',
                   functionName:'',
                   functionUrl:'',
                   enableFlag:true
               },
               rules:{
                    functionCode:[
                        {required:true,message:'功能编码不能为空', trigger: 'blur'}
                    ],
                    functionName:[
                       {required:true,message:'功能名称不能为空', trigger: 'blur'}
                    ],
                     functionUrl:[
                       {required:true,message:'功能路径不能为空', trigger: 'blur'}
                    ]
               }    
            };
        },
        components: {
            
        },
        created(){
           this.initData();
        },
        methods:{
            async initData(){
               if (this.functionId !=null){
                  this.queryFunction();
               }
            },
            closeDialog(){
                debugger;
                this.$emit('closeDialog', false);
                this.functionInfo={};
            },
            async queryFunction(functionId1){
               const functions = await queryById({functionId:functionId1});
               this.functionInfo=functions;
                
            },
           sumbmitData(formName){
                this.$refs[formName].validate(async (valid) => {
                 if(valid)
                {
                    let result=null;
                    if(this.functionInfo.pid ==null){
                        this.functionInfo.parentId=this.parentId;
                         result = await addFunction(this.functionInfo);
                    }else{
                         result= await updateFunction(this.functionInfo);
                    }
                    if(result.code == '0000'){
                           this.$message({
					           type: 'success',
					           message: '添加成功'
                           });
                          this.functionInfo={};
                          this.$emit('saveSuccess',false);
                       }
                       
                   } else {
						this.$notify.error({
							title: '错误',
							message: '请检查输入是否正确',
							offset: 100
						});
						return false;
					}
               });

           }
        },
        props: {
            visible: {
                type: Boolean,
                default: false
            },
            functionId:{
                type:String,
                default:null
            },
            parentId:{
                type:String,
                default:null
            }
        },
        watch: {
            show () { 
              
            }
        }
    };
</script>