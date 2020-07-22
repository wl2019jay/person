<template>
    <div class="tree">
        <el-dialog
            title="角色分配功能"
            :visible.sync="visible"
            width="30%"
            destroy-on-close="true"
            @close="$emit('closeDialog', false)">
            <div class="custom-tree-container">
            <div class="block" style="height:300px;overflow-y: auto"> 
                <el-tree
                :data.sync="data5"
                show-checkbox
                ref="functionTreeData"
                node-key="id"
                default-expand-all>
                <span class="custom-tree-node" slot-scope="{ node, data }">
                    
                    <span>
                        <i :class="data.icon"></i>{{ data.functionName }}
                    </span>              
                </span>
                </el-tree>
            </div>
            </div>
           <div slot="footer" class="dialog-footer">
                <el-button >取 消</el-button>
                <el-button type="primary" @click="submitData" >确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>
 
<script>
   import {functionTree} from '@/api/getData'
    let id = 1000;
    export default {
        data () {
            const data1 = [{
                id: 1,
                label: '一级',
                icon: 'el-icon-folder',
                children: [{
                id: 4,
                label: '二级 1-1',
                 icon: 'el-icon-folder',
                children: [{
                    id: 9,
                    label: '三级 1-1-1',
                     icon: 'el-icon-folder'
                }, {id: 10,
                    label: '三级 1-1-2',
                    icon: 'el-icon-folder'
                }]
                }]
            }, {
                id: 2,
                label: '一级 2',
                icon: 'el-icon-folder',
                children: [{
                id: 5,
                label: '二级 2-1',
                icon: 'el-icon-folder'
                }, {
                id: 6,
                label: '二级 2-2',
                icon: 'el-icon-folder'
                }]
            }, {
                id: 3,
                label: '一级 3',
                icon: 'el-icon-folder',
                children: [{
                id: 7,
                label: '二级 3-1',
                icon: 'el-icon-folder'
                }, {
                id: 8,
                label: '二级 3-2',
                icon: 'el-icon-folder'
                }]
            }];
            return {
                data5: data1
            };
        },
        components: {
        },
        created(){
          this.initData();
        },
        methods:{
            async initData(){
                try{
                            // const countData = await getUserCount();
                            // if (countData.status == 1) {
                            //     this.count = countData.count;
                            // }else{
                            //     throw new Error('获取数据失败');
                            // }
                        this.functionTree1();
                    }catch(err){
                    console.log('获取数据失败', err);
                }
                
            },
            async functionTree1(){
                const tree1 = await functionTree({});
                this.data5 =tree1;
            },
            submitData(){
              let treeData=this.$refs.functionTreeData;
              debugger;
            }
        },
        props: {
            visible: {
                type: Boolean,
                default: false
            },
            roleId:{
                type:String,
                default:'1'
            }
        },
        watch: {
            show () { 
                
            }
        }
    };
</script>
<style lang="less">
  
  .custom-tree-node {
    .el-tree-node__content{
        display: block!important;
     }
     .el-tree-node__children{
        overflow: visible!important;
     }
    
  }
</style>