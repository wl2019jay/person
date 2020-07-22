<template lang="html">
  <div id="fillcontain">
    <head-top></head-top>
    <div class="table_container">
        <el-row style="margin: 10px">
             <el-tooltip class="item" effect="dark" content="新增" placement="top-start">
                <el-button type="info" style="margin-right: 10px" @click="addData()"  icon="el-icon-plus" circle> </el-button>
             </el-tooltip>
             <el-tooltip class="item" effect="dark" content="删除" placement="top-start">
                <el-button type="danger" style="margin-right: 10px" @click="removeData()" icon="el-icon-delete" circle></el-button>
             </el-tooltip>
             <el-tooltip class="item" effect="dark" content="收起" placement="top-start">
                <el-button type="info" style="margin-right: 10px"  icon="el-icon-zoom-out" @click="foldAll()" circle></el-button>
             </el-tooltip>
             <el-tooltip class="item" effect="dark" content="展开" placement="top-start">
                <el-button type="info" style="margin-right: 10px" icon="el-icon-zoom-in" @click="expandAll()" circle></el-button>
            </el-tooltip>
        </el-row>
        <tree-table
        ref="table"
        sum-text="sum"
        index-text="#"
        :data.sync="functiondata"
        :columns="columns"
        :stripe="props.stripe"
        :border="props.border"
        :show-header="props.showHeader"
        :show-summary="props.showSummary"
        :show-row-hover="props.showRowHover"
        :show-index="props.showIndex"
        :tree-type="props.treeType"
        select-type="checkbox"
        :radio-status-reset="props.radioStatuReset"
        :is-fold="props.isFold"
        :expand-type="props.expandType"
        :loading="props.loading"
        force-expand-icon-prop="isBase"
        id-prop="id"
        expand-key="functionCode"
        :row-class-name="rowClassName"
        :maxHeight="tableHeight"
        :disabledRows="disabledRows"
        :checkedRows="checkedRows"
        :create-data-obj="createDataObj"
        @radio-click="handleRadioClick"
        @input-blur="inputOnBlur"
        @tree-icon-click="expandEvent"
        @on-sort-change="sortChangeFunc"
        :selectable="props.selectable">
        <!-- <tree-table
            :columns="columns"
            :expand-type="false"
            :selection-type="false"
            :data="data"> -->
        <template slot="$createdata" slot-scope="createdata">
            <div style="margin-left: 50px;padding: 5px;" v-show="!createdata.tmpData.status && createdata.rowIndex == -1">
            <el-button type="info" style="margin-left: 10px" @click="showCreateDataForm(createdata)">Add</el-button>
            </div>
            <div style="margin-left: 50px;padding: 5px;" v-show="createdata.tmpData.status">
            <el-form :model="createdata.tmpData.data" inline>
                <el-form-item prop="functionCode">
                    <el-input type="text" v-model="createdata.tmpData.data.functionCode" placeholder="functionCode">
                    </el-input>
                </el-form-item>
                <el-form-item prop="functionName">
                    <el-input type="text" v-model="createdata.tmpData.data.functionName" placeholder="functionName">
                    </el-input>
                </el-form-item>
                <el-form-item prop="functionUrl">
                    <el-input type="text" v-model="createdata.tmpData.data.functionUrl" placeholder="functionUrl">
                    </el-input>
                </el-form-item>
                <el-form-item prop="enableFlag">
                    <el-switch
                      v-model="createdata.tmpData.data.enableFlag"
                      active-color="#13ce66"
                      inactive-color="#ff4949">
                    </el-switch>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="addDataAndHideForm(createdata)">Add</el-button>
                </el-form-item>
            </el-form>
            </div>
        </template>
         <template slot="$expand" slot-scope="scope">
            <el-input type="text" v-text="sss"></el-input>
        </template> 
        <template slot="functionName" slot-scope="scope">
            <span :style="{'color': scope.row.functionName === 'male' ? 'green' : 'green  ' }">{{ scope.row.functionName }}</span>
        </template>
        <template slot="enableFLagTemp" slot-scope="scope">
            <el-switch
                 v-model="scope.row.enableFlag"
                  active-color="#1E90FF"
                  inactive-color="#D3D3D3"
                 disabled="true">
             </el-switch>
        </template>
         <template slot="handle" slot-scope="scope">
            <div style="margin-left: 10px;padding: 5px;">
                <el-tooltip class="item" effect="dark" content="新增子项" placement="top-start1">
                    <el-button type="success" icon="el-icon-plus"  @click="createChild(scope.row)" circle></el-button>
                </el-tooltip>
                <el-tooltip class="item" effect="dark" content="编辑" placement="top-start2">
                    <el-button type="primary" icon="el-icon-edit" @click="editChild(scope.row)" circle></el-button>
                </el-tooltip>
            </div> 
        </template>
        </tree-table>
         <add-function ref="addFunction" @closeDialog="closeDialog" @saveSuccess="saveSuccess" :visible="visible" :functionId="functionId" :parentId="parentId"></add-function>
    </div>
  </div>

</template>

<script>
  import headTop from '../components/headTop'
  import addFunction from '../components/addFunction'
  import {functionTree} from '@/api/getData'
  export default {
    name: 'example',
    components: {
      headTop,
      addFunction
    },
    data() {
      return {
        visible:false,
        functionId:null,
        parentId:null,
        props: {
          stripe: true,
          border: true,
          showHeader: true,
          showSummary: false,
          showRowHover: true,
          showIndex: true,
          treeType: true,
          isFold: true,
          loading: false,
          expandType: true,
          selectable: true,
          radioStatuReset: true,
        },
        createDataObj: {
          functionCode: '',
          functionName: '',
          functionUrl:'',
          enableFLag:''
        },
        functiondata: [
          {
            id: '1',
            parentId:'0',
            functionCode: 'Jack111111111111111111111111111111111',
            functionName: 'male',
            functionUrl: ['football', 'basketball'],
            enableFLag: 10
          },
          {
            id: '10',
            parentId:'0',
            functionCode: 'Tom',
            functionName: 'male',
            functionUrl: ['football', 'basketball'],
            enableFlag: 20
          },
          {
            id: '17',
            parentId:'0',
            functionCode: 'Tom',
            functionName: 'male',
            functionUrl: ['football', 'basketball'],
            enableFlag: 20,
          },
          {
            id: '18',
            parentId:'0',
            functionCode: 'Tom',
            functionName: 'male',
            functionUrl: ['football', 'basketball'],
            enableFlag: true,
            children: [
              {
                id: '19',
                parentId:'18',
                functionCode: 'Ashley',
                functionName: 'female',
                functionUrl: ['football', 'basketball'],
                enableFlag: 20,
              },
              {
                id: '20',
                parentId:'18',
                functionCode: 'Taki',
                functionName: 'male',
                functionUrl: ['football', 'basketball'],
                enableFlag: 10,
              },
            ],
          },
        ],
        columns: [
          {
            title: '功能编码',
            key: 'functionCode',
            headerAlign: 'center',
            align: 'center',
            fixed: 'left',
            width: 200,
            className: ['my-class-1', 'my-class-2'],
            sortable: true
          },
          {
                title: '功能名称',
                key: 'functionName',
                headerAlign: 'center',
                align: 'center',
                type: 'template',
                template: 'functionName',
                minWidth: 100
              },
              {
                title: '功能路径',
                key: 'functionUrl',
                headerAlign: 'center',
                align: 'center',
                minWidth: 50
              },
          {
            title: '是否有效',
            key: 'enableFLag',
            type:"template",
            headerAlign: 'center',
            template: 'enableFLagTemp',
            align: 'center',
            minWidth: 100
          },
          {
            title: '操作',
            type: 'template',
            template: 'handle',
            
          }
        ],
        formInline: {
          functionCode: 'Erixu',
          functionName: 'male',
          functionUrl:'XXXX',
          enableFLag:'Y'
        },
        tableHeight: 400,
        disabledRows: ['1','2','3'],
        checkedRows: ['1','2','3'],
        rowClassName: function(row, rowIndex) {
          if (rowIndex == 2) {
            return 'row-class-name';
          }
        }
      };
    },
    computed: {
      propList() {
        return Object.keys(this.props).map(item => ({
          functionCode: item,
        }));
      },
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
                this.functionTree1();
            }catch(err){
               console.log('获取数据失败', err);
           }
        
      },
      sortChangeFunc(column, orderType) {
        console.log(column);
        console.log(orderType);
      },
      showCreateDataForm(createData) {
        createData.tmpData.status = true;
      },
      closeDialog(){
          this.visible=false;
      },
      saveSuccess(){
         this.visible=false;
         this.functionTree1();
      },
      getMatchedRow(data, id, newData) {
        for (var i in data) {
            if (data[i].id == id) {
              if (data[i].children != undefined) {
                data[i].children.push(newData);
              } else {
                data[i].children = [];
                data[i].children.push(newData);
              }
              return true;
            }
        }
        for (var i in data) {
            if (data[i].children != undefined) {
              if (this.getMatchedRow(data[i].children, id, newData) == true) {
                return true;
              }
            }
        }
        return false;
      },
      addDataAndHideForm(createData) {
        var newData = {};
        Object.assign(newData, createData.tmpData.data);
        newData.id = Math.random().toString(36).substr(2);
        if (createData.rowIndex == -1) {
          this.data.push(newData);
        } else {
          // 递归获取
          this.getMatchedRow(this.data, createData.row.id, newData);
        }
        createData.tmpData.status = false;
      },
      createChild(row) {
        this.visible = true;
        this.parentId= row.pid;
        debugger;
      },
      async editChild(row) {
        this.visible = true;
        this.functionId = row.pid;
        this.$refs.addFunction.queryFunction(row.pid);
      },
      addData() {
        this.visible = true;
        this.parentId= null;
      },
       async functionTree1(){
           const tree1 = await functionTree({});
           this.functiondata =tree1;
           // tree;
       },
      removeData() {
        this.data[0].children.splice(1,1);
      },
      handleRadioClick(option) {
        // console.log(option); // eslint-disable-line
      },
      inputOnBlur(row) {
        console.log(row);
      },
      expandEvent(row, column, columnIndex, $event, isExpanded) {
        this.$refs.table.treeLoadingTrigger(row['id'], true);
        let $table = this.$refs.table;
        setTimeout(function(){
          $table.treeLoadingTrigger(row['id'], false);
        }, 1000);
      },
      // expandedIds() {
      //   this.$refs.table.getExpandedIds()
      // },
      foldAll() {
        this.$refs.table.foldAll(true);
      },
      expandAll() {
        this.$refs.table.foldAll(false);
      },
      getCheckedRows() {
        console.log(this.$refs.table.getCheckedProps(['id', 'functionCode', 'functionName']));
      }
    },
  };
</script>

<style scoped lang="less">
  .switch-list {
    margin: 20px 0;
    list-style: none;
    overflow: hidden;
  }

  .switch-item {
    margin: 20px;
    float: left;
  }

</style>

<style lang="less">
  .row-class-name {
    font-weight: bold;
  }
  .my-class-1 {
    width:100px;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .my-class-2 {
    color: green;
  }
</style>
