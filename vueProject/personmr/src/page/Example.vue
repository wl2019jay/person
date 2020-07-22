<template lang="html">
  <div id="example">
    <ul class="switch-list">
      <li class="switch-item" v-for="item in propList">
        <span>{{ item.name }}: </span>
        <zk-switch v-model="props[item.name]"></zk-switch>
      </li>
    </ul>
    <el-row style="margin: 10px">
        <el-button type="info" style="margin-right: 10px" @click="addData()">Add</el-button>
        <el-button type="error" style="margin-right: 10px" @click="removeData()">Remove</el-button>
        <el-button type="success" style="margin-right: 10px" @click="recoveryData()">Recovery</el-button>
        <el-button type="info" style="margin-right: 10px" @click="foldAll()">Fold All</el-button>
        <el-button type="info" style="margin-right: 10px" @click="expandAll()">Expand All</el-button>
        <el-button type="info" style="margin-right: 10px" @click="getCheckedRows()">Show checked Rows</el-button>
    </el-row>
    <tree-table
      ref="table"
      sum-text="sum"
      index-text="#"
      :data="data"
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
      expand-key="sex"
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
            <el-form-item prop="name">
                <el-input type="text" v-model="createdata.tmpData.data.name" placeholder="name">
                </el-input>
            </el-form-item>
            <el-form-item prop="sex">
                <el-input type="text" v-model="createdata.tmpData.data.sex" placeholder="sex">
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="addDataAndHideForm(createdata)">Add</el-button>
            </el-form-item>
          </el-form>
        </div>
      </template>
      <!-- <template slot="$expand" slot-scope="scope">
        {{ `My name is ${scope.row.name},
           this rowIndex is ${scope.rowIndex}.`
         }}
      </template> -->
      <template slot="sex" slot-scope="scope">
        <span :style="{'color': scope.row.sex === 'male' ? 'green' : 'red' }">{{ scope.row.sex }}</span>
      </template>
      <template slot="likes" slot-scope="scope">
          <el-dropdown trigger="click" @on-click="createChild(scope.row)">
              <el-button type="primary" icon="el-icon-plus">
              </el-button>
              <el-dropdown-menu>
                <el-dropdown-item name="1">新增子项</el-dropdown-item>
                <el-dropdown-item name="2">修改</el-dropdown-item>
                <el-dropdown-item name="3">删除</el-dropdown-item>
              </el-dropdown-menu>
          </el-dropdown>
      </template>
    </tree-table>
  </div>
</template>

<script>
  import ZkSwitch from './Switch/Switch';

  export default {
    name: 'example',
    components: {
      ZkSwitch,
    },
    data() {
      return {
        props: {
          stripe: false,
          border: true,
          showHeader: true,
          showSummary: false,
          showRowHover: true,
          showIndex: false,
          treeType: true,
          isFold: true,
          loading: false,
          expandType: false,
          selectable: false,
          radioStatuReset: true,
        },
        createDataObj: {
          name: '',
          sex: ''
        },
        data: [
          {
            id: '1',
            name: 'Jack111111111111111111111111111111111',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 10
          },
          {
            id: '10',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20
          },
          {
            id: '17',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20,
          },
          {
            id: '18',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20,
            children: [
              {
                id: '19',
                name: 'Ashley',
                sex: 'female',
                likes: ['football', 'basketball'],
                score: 20,
              },
              {
                id: '20',
                name: 'Taki',
                sex: 'male',
                likes: ['football', 'basketball'],
                score: 10,
              },
            ],
          },
        ],
        dataNormal: [
          {
            id: '1',
            name: 'Jack',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 10,
            children: [
              {
                id: '2',
                name: 'Ashley',
                sex: 'female',
                likes: ['football', 'basketball'],
                score: 20,
                children: [
                  {
                    id: '3',
                    name: 'Ashley',
                    sex: 'female',
                    likes: ['football', 'basketball'],
                    score: 20,
                  },
                  {
                    id: '4',
                    name: 'Taki',
                    sex: 'male',
                    likes: ['football', 'basketball'],
                    score: 10,
                    children: [
                      {
                        id: '5',
                        name: 'Ashley',
                        sex: 'female',
                        likes: ['football', 'basketball'],
                        score: 20,
                      },
                      {
                        id: '6',
                        name: 'Taki',
                        sex: 'male',
                        likes: ['football', 'basketball'],
                        score: 10,
                        children: [
                          {
                            id: '7',
                            name: 'Ashley',
                            sex: 'female',
                            likes: ['football', 'basketball'],
                            score: 20,
                          },
                          {
                            id: '8',
                            name: 'Taki',
                            sex: 'male',
                            likes: ['football', 'basketball'],
                            score: 10,
                          },
                        ],
                      },
                    ],
                  },
                ],
              },
              {
                id: '9',
                name: 'Taki',
                sex: 'male',
                likes: ['football', 'basketball'],
                score: 10,
              },
            ],
          },
          {
            id: '10',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20,
            children: [
              {
                id: '11',
                name: 'Ashley',
                sex: 'female',
                likes: ['football', 'basketball'],
                score: 20,
                children: [
                  {
                    id: '12',
                    name: 'Ashley',
                    sex: 'female',
                    likes: ['football', 'basketball'],
                    score: 20,
                  },
                  {
                    id: '13',
                    name: 'Taki',
                    sex: 'male',
                    likes: ['football', 'basketball'],
                    score: 10,
                  },
                ],
              },
              {
                id: '14',
                name: 'Taki',
                sex: 'male',
                likes: ['football', 'basketball'],
                score: 10,
                children: [
                  {
                    id: '15',
                    name: 'Ashley',
                    sex: 'female',
                    likes: ['football', 'basketball'],
                    score: 20,
                  },
                  {
                    id: '16',
                    name: 'Taki',
                    sex: 'male',
                    likes: ['football', 'basketball'],
                    score: 10,
                  },
                ],
              },
            ],
          },
          {
            id: '17',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20,
          },
          {
            id: '18',
            name: 'Tom',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20,
            children: [
              {
                id: '19',
                name: 'Ashley',
                sex: 'female',
                likes: ['football', 'basketball'],
                score: 20,
              },
              {
                id: '20',
                name: 'Taki',
                sex: 'male',
                likes: ['football', 'basketball'],
                score: 10,
              },
            ],
          },
        ],
        columns: [
          {
            title: 'name',
            key: 'name',
            headerAlign: 'center',
            align: 'center',
            fixed: 'left',
            width: 200,
            className: ['my-class-1', 'my-class-2'],
            sortable: true
          },
          {
            title: 'total',
            headerAlign: 'center',
            align: 'center',
            children: [
              {
                title: 'sex',
                key: 'sex',
                headerAlign: 'center',
                align: 'center',
                type: 'template',
                template: 'sex',
                minWidth: 100
              },
              {
                title: 'score',
                key: 'score',
                headerAlign: 'center',
                align: 'center',
                minWidth: 50
              }
            ]
          },
          {
            title: 'likes',
            key: 'likes',
            headerAlign: 'center',
            align: 'center',
            type: 'template',
            template: 'likes',
            minWidth: 100,
            sortable: true
          },
          {
            title: 'team',
            key: 'team',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary',
            key: 'salary',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary2',
            key: 'salary2',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary3',
            key: 'salary3',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary4',
            key: 'salary4',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary5',
            key: 'salary5',
            headerAlign: 'center',
            align: 'center',
            minWidth: 100
          },
          {
            title: 'salary6',
            key: 'salary6',
            headerAlign: 'center',
            align: 'center',
            width: 100
          }
        ],
        formInline: {
          name: 'Erixu',
          sex: 'male',
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
          name: item,
        }));
      },
    },
    methods: {
      sortChangeFunc(column, orderType) {
        console.log(column);
        console.log(orderType);
      },
      showCreateDataForm(createData) {
        createData.tmpData.status = true;
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
        this.$refs.table.tmpData[row.id].status = true;
      },
      addData() {
        // 展开
        this.$refs.table.setDefaultExpandItems(['17']);
        var newData = [];
        Object.assign(newData, this.data);
        newData[2].children = [
          {
            id: Math.random().toString(36).substr(2),
            name: 'Wenxing',
            sex: 'male',
            likes: ['football', 'basketball'],
            score: 20
          }
        ];
        this.data = newData;
      },
      removeData() {
        this.data[0].children.splice(1,1);
      },
      recoveryData() {
        let firstChildren = this.dataNormal[0].children;
        this.data[0].children = [...firstChildren];
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
        console.log(this.$refs.table.getCheckedProps(['id', 'name', 'sex']));
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
    color: red;
  }
</style>
