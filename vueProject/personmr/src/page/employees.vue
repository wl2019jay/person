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
                  property="employeeCode"
                  label="员工编码"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="name"
                  label="员工名称"
                  width="220">
                </el-table-column>
                <el-table-column
                  property="phone"
                  label="电话号码">
                </el-table-column>
                <el-table-column
                  property="email"
                  label="邮箱">
                </el-table-column>
                <el-table-column
                  property="sex"
                  label="性别">
                </el-table-column>
                <el-table-column
                  property="cityName"
                  label="城市">
                </el-table-column>
                <el-table-column
                  property="address"
                  label="详细地址">
                </el-table-column>
                <el-table-column
                  property="enableFlag"
                  label="是否已冻结">
                </el-table-column>
                <el-table-column
                  property="idNum"
                  label="身份证">
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
        
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {queryEmployees, queryEmployeesCount} from '@/api/getData'
    export default {
        data(){
            
            return {
                tableData: [{
                  employeeCode: 'XXXXX',
                  name: '王小虎'
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                currentPage: 1
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
                    this.queryEmployees();
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
                this.queryEmployees()
            },
             handleEdit(flag) {
                this.$router.push({path:'/addEmployee'});
            },
            async queryEmployees(){
                const employees = await queryEmployees({offset: this.offset, limit: this.limit});
                this.tableData = [];
                employees.forEach(item => {
                    const tableData = {};
                    tableData.employeeCode = item.employeeCode;
                    tableData.name = item.name;
                    tableData.phone = item.phone;
                    tableData.email = item.email;
                    tableData.address = item.address;
                    tableData.sex = item.sex;
                    tableData.cityName = item.cityName;
                    tableData.enableFlag =item.enableFlag;
                    tableData.idNum = item.idNum;
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
