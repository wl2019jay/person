<template>
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <el-row>
                <el-tooltip class="item" effect="dark" content="新增" placement="top-start">
                    <el-button type="info"  @click="$refs.elxEditable.insert({name: 'new1'})"  icon="el-icon-plus" circle></el-button>
                </el-tooltip>
                <el-tooltip class="item" effect="dark" content="保存" placement="top">
                    <el-button type="warning" icon="el-icon-document" @click="saveRole()" circle></el-button>
                </el-tooltip>
                 <el-tooltip class="item" effect="dark" content="删除"  placement="top-end">
                    <el-button type="danger" icon="el-icon-delete"  @click="$refs.elxEditable.removeSelecteds()" circle></el-button>
                 </el-tooltip>
            </el-row>
            <elx-editable
                :data.sync="elxEditableData"
                ref="elxEditable"
                :fixed="false"
                :stripe="stripe"
                :border="border"
                :resizable="resizable"
                :config="{autoScrollIntoView: 'true', renderSize: 60,mode: 'row'}"
                highlight-current-row
                style="width: 100%">
                <elx-editable-column
                  type="selection"
                  width="50">
                </elx-editable-column>
                <elx-editable-column
                  type="index"
                  width="50">
                </elx-editable-column>
                <elx-editable-column
                  prop="roleCode"
                  label="角色编码"
                  :edit-render="{name: 'ElInput'}">
                </elx-editable-column>
                <elx-editable-column
                  prop="roleName"
                  label="角色名称"
                  :edit-render="{name: 'ElInput'}">
                </elx-editable-column>
                <elx-editable-column
                  prop="startTime"
                  label="开始时间"
                  :edit-render="{name: 'ElDatePicker', props: {type: 'date',format: 'yyyy-MM-dd'}}"
                  >
                </elx-editable-column>
                <elx-editable-column
                  prop="endTime"
                  label="结束时间"
                  :edit-render="{name: 'ElDatePicker', props: {type: 'date', format: 'yyyy-MM-dd'}}"
                  >
                </elx-editable-column>
                 <elx-editable-column
                  prop="enableFlag"
                  label="是否有效"
                  :edit-render="{name: 'ElSwitch',type:'visible'}"
                  >
                </elx-editable-column>
                  <elx-editable-column
                  label="操作"
                  >
                   <el-button type="primary"  @click="selectFunction"> 分配</el-button>
                </elx-editable-column>
            </elx-editable>
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
         <function-select :ref="functionSelect" @closeDialog="closeDialog" :visible="visible" :roleId="roleId"></function-select>
    </div>
   
</template>

<script>
    import headTop from '../components/headTop'
    import functionSelect from '../components/functionSelect'
    import {saveRole, queryRole} from '@/api/getData'
    import moment from 'moment'
    export default {
        data(){
            
            return {
                elxEditableData: [{
                    roleCode:'xxxx',
                    roleName:'rrrrr'
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                stripe:'',
                visible:false,
                roleId:null,
                newRoles:[],
                removeRoles:[],
                updateRoles:[],
                currentPage: 1,
                sexList: [
                    {
                    'label': '男',
                    'value': '1'
                    },
                    {
                    'label': '女',
                    'value': '0'
                    }
                ]
            }
        },
    	components: {
            headTop,
            functionSelect
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
                    this.queryRole();
                }catch(err){
                    console.log('获取数据失败', err);
                }
            },
            selectFunction(row, column, $index, $render){
                debugger;
               this.visible=true;
            },
            closeDialog(){
                this.visible=false;
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.queryRole()
            },
             handleEdit(flag) {
                this.$router.push({path:'/addEmployee'});
            },
            async saveRole(){
              const insertReords=this.$refs.elxEditable.getInsertRecords();
              const removeRecords=this.$refs.elxEditable.getRemoveRecords();
              const updateRecords=this.$refs.elxEditable.getUpdateRecords(); 
              debugger;
              this.updateRoles=[];
              this.newRoles=[];
              this.removeRoles=[];
              insertReords.forEach(item =>{
                 const tableData = {};
                  tableData.roleCode = item.roleCode;
                  tableData.roleName = item.roleName;
                 if(item.startTime!=''&&item.startTime!=null){
                     tableData.startTime = moment(item.startTime).format('YYYY-MM-DD');
                  }
                  if(item.endTime!=''&&item.endTime!=null){
                    tableData.endTime =  moment(item.endTime).format('YYYY-MM-DD');
                  }
                  tableData.enableFlag = item.enableFlag;
                  this.newRoles.push(tableData);
              });
              removeRecords.forEach(item =>{
                 const tableData = {};
                  tableData.roleCode = item.roleCode;
                  tableData.roleName = item.roleName;
                  if(item.startTime!=''&&item.startTime!=null){
                     tableData.startTime = moment(item.startTime).format('YYYY-MM-DD');
                  }
                  if(item.endTime!=''&&item.endTime!=null){
                    tableData.endTime =  moment(item.endTime).format('YYYY-MM-DD');
                  }
                  tableData.enableFlag = item.enableFlag;
                  tableData.pid =item.pid;
                  this.removeRoles.push(tableData);
              });
              updateRecords.forEach(item =>{
                 const tableData = {};
                  tableData.roleCode = item.roleCode;
                  tableData.roleName = item.roleName;
                  if(item.startTime!=''&&item.startTime!=null){
                     tableData.startTime = moment(item.startTime).format('YYYY-MM-DD');
                  }
                  if(item.endTime!=''&&item.endTime!=null){
                    tableData.endTime =  moment(item.endTime).format('YYYY-MM-DD');
                  }
                  tableData.enableFlag = item.enableFlag;
                  tableData.pid =item.pid;
                  this.updateRoles.push(tableData);
              });

             const result = await saveRole({newItem: this.newRoles, updateItem: this.updateRoles,removeItem:this.removeRoles});
             this.queryRole();
            },
            async queryRole(){
                const roles = await queryRole({offset: this.offset, limit: this.limit});
                debugger;
                this.elxEditableData = [];
                const This=this;
                roles.forEach(item => {
                    const tableData = {};
                    tableData.roleCode = item.roleCode;
                    tableData.roleName = item.roleName;
                    tableData.startTime = item.startTime;
                    tableData.endTime = item.endTime;
                    tableData.enableFlag = item.enableFlag;
                    tableData.pid =item.pid;
                    This.elxEditableData.push(tableData);
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
