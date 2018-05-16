var prefix = "/customer";
$(function() {
	load();
});
 $('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.records.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						striped : true, // 设置为true会有隔行变色效果
                        dataField: "records",//这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 2, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						search : true, // 是否显示搜索框
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
                       // queryParams:queryParams,//请求服务器时所传的参数
						// "server"
						// queryParams : queryParams,
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
                     queryParams:function queryParams(params) {   //设置查询参数

                            var page = {

                                size : params.limit,
                                current : params.offset,
                                search: "",
                                sort:"",
                                order:"",

                            };

                            //alert("param.pageNumber="+param.pageNumber+" param.limit="+param.limit);
                            return page;
                        },
						columns : [
								{ // 列配置项
									// 数据类型，详细参数配置参见文档http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
									checkbox : true
								// 列表中显示复选框
								},
                           		 {
                              		  field: 'Number' ,
									 title: '序号' ,
                               		 formatter: function (value, row, index) {
                                    		var pageSize=$('#exampleTable').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                                    		var pageNumber=$('#exampleTable').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                                    		return pageSize * (pageNumber - 1) + index + 1;
                               		 }
                           		 },
                            {
                                field : 'name',
                                title : '姓名'
                            },
                            {
                                field : 'username',
                                title : '用户名'
                            },
                            {
                                field : 'email',
                                title : '邮箱'
                            },
                            {
                                field : 'sex', // 列字段名
                                title : '性别' // 列标题
                            },
                            {
                                field : 'status',
                                title : '状态',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    if (value == '0') {
                                        return '<span class="label label-danger">禁用</span>';
                                    } else if (value == '1') {
                                        return '<span class="label label-primary">正常</span>';
                                    }
                                }
                            },
                            {
                                title : '操作',
                                field : 'id',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                        + row.id
                                        + '\')"><i class="fa fa-edit "></i></a> ';
                                    var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                        + row.id
                                        + '\')"><i class="fa fa-remove"></i></a> ';
                                    return e + d ;
                                }
                            } ]
                    });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
//请求服务数据时所传参数
/*
function queryParams(params){
    return {
        page:{
            size: params.pageSize,   //每页多少条数据 //每一页的数据行数，默认是上面设置的10(pageSize)
            current: params.pageNumber//当前页面,默认是上面设置的1(pageNumber)
		}

      // param : "Your Param" //这里是其他的参数，根据自己的需求定义，可以是多个
    }
}
*/


function add() {
	// iframe层
	layer.open({
		type : 2,
		title : '添加角色',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code === 0) {
					layer.msg("删除成功");
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})

}
function edit(id) {
	layer.open({
		type : 2,
		title : '角色修改',
		maxmin : true,
		shadeClose : true, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function resetPwd(id) {
    layer.open({
        type : 2,
        title : '重置密码',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '400px', '260px' ],
        content : prefix + '/resetPwd/' + id // iframe的url
    });
}
function batchRemove() {
	
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	}, function() {
		var ids = new Array();
		$.each(rows, function(i, row) {
			ids[i] = row['roleId'];
		});
		console.log(ids);
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {});
}