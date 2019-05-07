//获取当前登录的用户名
function getLoginMember() {
    $.ajax({
        type: "GET",
        url: "/adminLogin",
        success: function (result) {
            $("#loginMember").append(result.extended.member.memberName);
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//获取成员
function getAdminMember(pn) {
    $.ajax({
        type: "GET",
        url: "/adminMember",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th1 = $("<th></th>").append("姓名");
            var th2 = $("<th></th>").append("学习方向");
            var th3 = $("<th></th>").append("学号");
            var th4 = $("<th></th>").append("手机号码");
            var th5 = $("<th></th>").append("生日");
            var th6 = $("<th></th>").append("专业班级");
            var th7 = $("<th></th>").append("毕业去向");
            var th8 = $("<th></th>").append("操作");
            $("<tr></tr>").append(th1).append(th2).append(th3).append(th4).append(th5).append(th6).append(th7).append(th8).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            var loginMember = $("#loginMember").text();


            $.each(memberList, function (each, item) {
                var memberId = item.memberId;
                var memberName = item.memberName;
                var memberStudentid = item.memberStudentid;
                var phoneNumber = item.phoneNumber;
                var birthday = item.birthday;
                var afterGraduated = item.afterGraduated;
                var major = item.major;
                var memberDirect = item.memberDirect;
                var td1 = $("<td style='display:none'></td>").append(memberId);
                var td2 = $("<td></td>").append(memberStudentid);
                var td3 = $("<td></td>").append(phoneNumber);
                var td4 = $("<td></td>").append(birthday);
                var td5 = $("<td></td>").append(afterGraduated);
                var td6 = $("<td></td>").append(major);
                var td7 = $("<td></td>").append(memberDirect);
                var td8 = $("<td></td>").append(memberName);
                var edit_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='showModel(" + memberId + ")' style='padding:5px 10px;margin-right:5px'>编辑</button>");
                var del_Btn = $("<button type='button' class='btn btn-danger  btn-lg' onclick='delMember(" + memberId + ")' style='padding:5px 10px'>删除</button>");
                if (memberName == loginMember.substring(4)) {
                    //添加编辑及删除按钮         
                    var td9 = $("<td style='text-align:center;float:left'></td>").append(edit_Btn).append(del_Btn);
                    $("<tr></tr>").append(td1).append(td8).append(td7).append(td2).append(td3).append(td4).append(td6).append(td5).append(td9).appendTo("#member_table");

                } else {
                    //添加删除按钮
                    var td9 = $("<td style='text-align:center;float:left'></td>").append(del_Btn);
                    $("<tr></tr>").append(td1).append(td8).append(td7).append(td2).append(td3).append(td4).append(td6).append(td5).append(td9).appendTo("#member_table");
                }
            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getAdminMember(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getAdminMember(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getAdminMember(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//获取某一个成员信息
function showModel(memberId) {
    $("#myModal").modal('show');
    $.ajax({
        type: "GET",
        url: "/adminMember/" + memberId,
        dataType: "JSON",
        success: function (result) {
            var member = result.extended.member;
            var memberName = member.memberName;
            var memberStudentid = member.memberStudentid;
            var phoneNumber = member.phoneNumber;
            var birthday = member.birthday;
            var afterGraduated = member.afterGraduated;
            var major = member.major;
            var memberDirect = member.memberDirect;
            $("#memberId").val(memberId);
            $("#memberName").val(memberName);
            $("#memberStudentid").val(memberStudentid);
            $("#phoneNumber").val(phoneNumber);
            $("#birthday").val(birthday);
            $("#afterGraduated").val(afterGraduated);
            $("#major").val(major);
            $("#memberDirect").val(memberDirect);
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//更新成员信息
function updateMember(memberId) {
    $("#myModal").modal('hide');
    $.ajax({
        type: "PUT",
        url: "/adminMember/" + memberId,
        data: {
            "memberName": $("#memberName").val(),
            "memberStudentid": $("#memberStudentid").val(),
            "phoneNumber": $("#phoneNumber").val(),
            "birthday": $("#birthday").val(),
            "afterGraduated": $("#afterGraduated").val(),
            "major": $("#major").val(),
            "memberDirect": $("#memberDirect").val(),
            "memberPassword": $("#memberPassword").val(),
        },
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}

//根据id删除成员
function delMember(memberId) {
    if (window.confirm("是否确认删除?删除后无法重新添加成员!请谨慎操作!")) {
        $.ajax({
            type: "POST",
            url: "/adminMember/" + memberId,
            data: {
                _method: "DELETE",
                "memberId": memberId
            },
            dataType: "JSON",
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//获取投递简历
function getResume(pn) {
    $.ajax({
        type: "GET",
        url: "/adminResume",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th1 = $("<th></th>").append("姓名");
            var th2 = $("<th></th>").append("学习方向");
            var th3 = $("<th></th>").append("学号");
            var th4 = $("<th></th>").append("手机号码");
            var th5 = $("<th></th>").append("专业班级");
            var th6 = $("<th></th>").append("微信号");
            $("<tr></tr>").append(th1).append(th2).append(th3).append(th4).append(th5).append(th6).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            $.each(memberList, function (each, item) {
                var resuId = item.resuId;
                var resuName = item.resuName;
                var resuStudentid = item.resuStudentid;
                var resuNumber = item.resuNumber;
                var resuMajor = item.resuMajor;
                var resuWechat = item.resuWechat;
                var resuDirect = item.resuDirect;
                var td1 = $("<td style='display:none'></td>").append(resuId);
                var td2 = $("<td></td>").append(resuStudentid);
                var td3 = $("<td></td>").append(resuNumber);
                var td4 = $("<td></td>").append(resuWechat);
                var td5 = $("<td></td>").append(resuMajor);
                var td6 = $("<td></td>").append(resuDirect);
                var td7 = $("<td></td>").append(resuName);
                var collect_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='resu_detail(" + resuId + ")' style='padding:5px 10px;margin-right:5px'>查看详情</button>");
                //添加查看详情按钮         
                var td9 = $("<td style='text-align:center;float:left'></td>").append(collect_Btn);
                $("<tr></tr>").append(td1).append(td7).append(td6).append(td2).append(td3).append(td5).append(td4).append(td9).appendTo("#member_table");
            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getResume(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getResume(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getResume(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//查看简历详情
function resu_detail(resuId) {
    $("#myModal").modal('show');
    $.ajax({
        type: "GET",
        url: "/adminResume/" + resuId,
        success: function (result) {
            var resume = result.extended.resume;
            var resuId = resume.resuId;
            var resuName = resume.resuName;
            var resuStudentid = resume.resuStudentid;
            var resuNumber = resume.resuNumber;
            var resuMajor = resume.resuMajor;
            var resuWechat = resume.resuWechat;
            var resuDirect = resume.resuDirect;
            var resuEvaluation = resume.resuEvaluation;
            var resuSkills = resume.resuSkills;
            var resuExp = resume.resuExp;
            var resuExpect = resume.resuExpect;
            var resuOther = resume.resuOther;
            $("#resuId").val(resuId);
            $("#resuName").val(resuName);
            $("#resuStudentid").val(resuStudentid);
            $("#resuNumber").val(resuNumber);
            $("#resuMajor").val(resuMajor);
            $("#resuWechat").val(resuWechat);
            $("#resuDirect").val(resuDirect);
            $("#resuEvaluation").val(resuEvaluation);
            $("#resuSkills").val(resuSkills);
            $("#resuExp").val(resuExp);
            $("#resuExpect").val(resuExpect);
            $("#resuOther").val(resuOther);
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}

//一轮通过
function collectResume(resuId) {
    $("#myModal").modal('hide');
    $.ajax({
        type: "POST",
        url: "/adminResume/" + resuId,
        data: $("#form").serialize(),
        dateType: "JSON",
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//根据id删除简历
function delResume(resuId) {
    if (window.confirm("是否确认删除?此操作无法撤回!请谨慎操作!")) {
        $.ajax({
            type: "POST",
            url: "/adminResume/" + resuId,
            data: {
                _method: "DELETE",
                "memberId": resuId
            },
            dataType: "JSON",
            success: function (result) {
                $("#myModal").modal('hide');
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//添加根据名字和学习方向查找简历
function add_Name_Direct_Btn() {

}

//获取一轮通过简历
function getCollectResume(pn) {
    $.ajax({
        type: "GET",
        url: "/collectResume",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th1 = $("<th></th>").append("姓名");
            var th2 = $("<th></th>").append("学习方向");
            var th3 = $("<th></th>").append("学号");
            var th4 = $("<th></th>").append("手机号码");
            var th5 = $("<th></th>").append("专业班级");
            var th6 = $("<th></th>").append("微信号");
            $("<tr></tr>").append(th2).append(th3).append(th1).append(th4).append(th5).append(th6).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            $.each(memberList, function (each, item) {
                var colResuId = item.colResuId;
                var colResuName = item.colResuName;
                var colResuStudentid = item.colResuStudentid;
                var colResuNumber = item.colResuNumber;
                var colResuMajor = item.colResuMajor;
                var colResuWechat = item.colResuWechat;
                var colResuDirect = item.colResuDirect;
                var td1 = $("<td style='display:none'></td>").append(colResuId);
                var td2 = $("<td></td>").append(colResuName);
                var td3 = $("<td></td>").append(colResuStudentid);
                var td4 = $("<td></td>").append(colResuNumber);
                var td5 = $("<td></td>").append(colResuMajor);
                var td6 = $("<td></td>").append(colResuWechat);
                var td7 = $("<td></td>").append(colResuDirect);
                var detail_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='col_resu_detail(" + colResuId + ")' style='padding:5px 10px;margin-right:5px'>查看详情</button>");
                //添加查看详情按钮         
                var td9 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
                $("<tr></tr>").append(td1).append(td7).append(td6).append(td2).append(td3).append(td5).append(td4).append(td9).appendTo("#member_table");
            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getCollectResume(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getCollectResume(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getCollectResume(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//查看一轮通过简历详情
function col_resu_detail(colResuId) {
    $("#myModal").modal('show');
    $.ajax({
        type: "GET",
        url: "/collectResume/" + colResuId,
        success: function (result) {
            var resume = result.extended.resume;
            var colResuId = resume.colResuId;
            var colResuName = resume.colResuName;
            var colResuStudentid = resume.colResuStudentid;
            var colResuNumber = resume.colResuNumber;
            var colResuMajor = resume.colResuMajor;
            var colResuWechat = resume.colResuWechat;
            var colResuDirect = resume.colResuDirect;
            var colResuEvaluation = resume.colResuEvaluation;
            var colResuSkills = resume.colResuSkills;
            var resuExcolResuExpp = resume.colResuExp;
            var colResuExpect = resume.colResuExpect;
            var colResuOther = resume.colResuOther;
            $("#colResuId").val(colResuId);
            $("#colResuName").val(colResuName);
            $("#colResuStudentid").val(colResuStudentid);
            $("#colResuNumber").val(colResuNumber);
            $("#colResuMajor").val(colResuMajor);
            $("#colResuWechat").val(colResuWechat);
            $("#colResuDirect").val(colResuDirect);
            $("#colResuEvaluation").val(colResuEvaluation);
            $("#colResuSkills").val(colResuSkills);
            $("#colResuExp").val(colResuExp);
            $("#colResuExpect").val(colResuExpect);
            $("#colResuOther").val(colResuOther);
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}

//加入团队
function addMember(colResuId) {
    $("#myModal").modal('hide');
    $.ajax({
        type: "POST",
        url: "/collectResume/" + colResuId,
        data: {
            "colResuName": $("#colResuName").val(),
            "colResuStudentid": $("#colResuStudentid").val(),
            "colResuMajor": $("#colResuMajor").val(),
            "colResuNumber": $("#colResuNumber").val(),
            "colResuDirect": $("#colResuDirect").val()
        },
        dateType: "JSON",
        success: function (result) {
            $("#myModal").modal('hide');
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//根据id删除一轮通过简历
function col_delResume(colResuId) {
    if (window.confirm("是否确认删除?此操作无法撤回!请谨慎操作!")) {
        $.ajax({
            type: "POST",
            url: "/collectResume/" + colResuId,
            data: {
                _method: "DELETE",
                "colResuId": colResuId,
            },
            dataType: "JSON",
            success: function (result) {
                $("#myModal").modal('hide');
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//获取通告
function getAdminInform(pn) {
    $.ajax({
        type: "GET",
        url: "/adminInform",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th2 = $("<th></th>").append("创建时间");
            var th3 = $("<th></th>").append("内容");
            var th4 = $("<th></th>").append("创建人");
            $("<tr></tr>").append(th2).append(th3).append(th4).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            $.each(memberList, function (each, item) {
                var informId = item.informId;
                var createTime = item.createTime;
                var informInfo = item.informInfo;
                var username = item.username;
                var td1 = $("<td style='display:none'></td>").append(informId);
                var td2 = $("<td></td>").append(createTime);
                var td3 = $("<td></td>").append(informInfo);
                var td4 = $("<td></td>").append(username);
                var detail_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='inform_detail(" + informId + ")' style='padding:5px 10px;margin-right:5px'>查看详情</button>");
                var td5 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
                $("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).appendTo("#member_table");

            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getAdminInform(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getAdminInform(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getAdminInform(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//获取通告详情
function inform_detail(informId) {
    $.ajax({
        type: "GET",
        url: "/adminInform/" + informId,
        data: {
            "informId": informId
        },
        success: function (result) {
            var inform = result.extended.inform;
            var informId = inform.informId;
            var informInfo = inform.informInfo;
            var createTime = inform.createTime;
            var username = inform.username;
            $("#informId").val(informId);
            $("#informInfo").val(informInfo);
            $("#createTime").val(createTime);
            $("#username").val(username);
            $("#myModal").modal('show');
        },
        error: function (result) {
            alert(msg);
        }
    });
}

//更新通告
function updateInform(informId) {
    if ($("#username").val() != $("#loginMember").text().substring(4)) {
        alert("你没有权限修改别人发布的通告!");
        return false;
    } else {
        $.ajax({
            type: "PUT",
            url: "/adminInform/" + informId,
            data: $("#form").serialize(),
            success: function (result) {
                alert(result.msg);
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }

}

//根据id删除通告
function delInform(informId) {
    if (window.confirm("是否确认删除?")) {
        $.ajax({
            type: "POST",
            url: "/adminInform/" + informId,
            data: {
                _method: "DELETE",
                "informId": informId
            },
            dataType: "JSON",
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//获取当前时间并格式化
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentDate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + date.getHours() + seperator2 + date.getMinutes() + seperator2 + date.getSeconds();
    return currentDate;
}

function Inform_modal() {
    $("#add_username").val($("#loginMember").text().substring(4));
    var currentDate1 = getNowFormatDate();
    $("#createTime").val(currentDate1);
    $("#myModal_add").modal('show');
}

//发布通告
function addInform() {
    $.ajax({
        type: "POST",
        url: "/adminInform",
        data: {
            "informInfo": $("#add_informInfo").val(),
            "username": $("#loginMember").text().substring(4),
        },
        dataType: "JSON",
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}

//获取奖项
function getAdminAward(pn) {
    $.ajax({
        type: "GET",
        url: "/adminAward",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th2 = $("<th></th>").append("奖项名称");
            var th3 = $("<th></th>").append("获奖时间");
            var th4 = $("<th></th>").append("创建人");
            $("<tr></tr>").append(th2).append(th3).append(th4).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            $.each(memberList, function (each, item) {
                var awardId = item.awardId;
                var awardName = item.awardName;
                var awardTime = item.awardTime;
                var awardUsername = item.awardUsername;
                var td1 = $("<td style='display:none'></td>").append(awardId);
                var td2 = $("<td></td>").append(awardName);
                var td3 = $("<td></td>").append(awardTime);
                var td4 = $("<td></td>").append(awardUsername);
                var detail_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='award_detail(" + awardId + ")' style='padding:5px 10px;margin-right:5px'>查看详情</button>");
                var td5 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
                $("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).appendTo("#member_table");
            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getAdminAward(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getAdminAward(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getAdminAward(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//获取奖项详情
function award_detail(awardId) {
    $.ajax({
        type: "GET",
        url: "/adminAward/" + awardId,
        data: {
            "awardId": awardId
        },
        success: function (result) {
            var award = result.extended.award;
            var awardId = award.awardId;
            var awardName = award.awardName;
            var awardTime = award.awardTime;
            var awardUsername = award.awardUsername;
            $("#awardId").val(awardId);
            $("#awardName").val(awardName);
            $("#awardTime").val(awardTime);
            $("#awardUsername").val(awardUsername);
            $("#myModal").modal('show');
        },
        error: function (result) {
            alert(msg);
        }
    });
}

//更新奖项
function updateAward(awardId) {
    if ($("#awardUsername").val() != $("#loginMember").text().substring(4)) {
        alert("你没有权限修改别人发布的奖项!");
        return false;
    } else {
        $.ajax({
            type: "PUT",
            url: "/adminAward/" + awardId,
            data: $("#form").serialize(),
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//根据id删除奖项
function delAward(awardId) {
    if (window.confirm("是否确认删除?")) {
        $.ajax({
            type: "POST",
            url: "/adminAward/" + awardId,
            data: {
                _method: "DELETE",
                "awardId": awardId
            },
            dataType: "JSON",
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}
//奖项详情
function award_modal() {
    $("#add_username").val($("#loginMember").text().substring(4));
    $("#myModal_add").modal('show');
}

//发布奖项
function addAward() {
    $.ajax({
        type: "POST",
        url: "/adminAward",
        data: {
            "awardName": $("#add_awardName").val(),
            "awardUsername": $("#loginMember").text().substring(4),
            "awardTime": $("#add_awardTime").val()
        },
        dataType: "JSON",
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}

//获取项目
function getAdminProject(pn) {
    $.ajax({
        type: "GET",
        url: "/adminProject",
        data: {
            "pn": pn
        },
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th2 = $("<th></th>").append("项目名称");
            var th3 = $("<th style='text-align:center'></th>").append("项目图片");
            var th4 = $("<th></th>").append("创建人");
            $("<tr></tr>").append(th2).append(th3).append(th4).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
            $.each(memberList, function (each, item) {
                var proId = item.proId;
                var proName = item.proName;
                var proUsername = item.proUsername;
                var photo = item.photo;
                var photoLoc = photo.photoLoc;
                var td1 = $("<td style='display:none'></td>").append(proId);
                var td2 = $("<td></td>").append(proName);
                var img = $("<img src=" + photoLoc + " style='width:200px;height:80px'>");
                var td3 = $("<td style='text-align:center'></td>").append(img);
                var td4 = $("<td></td>").append(proUsername);
                var detail_Btn = $("<button type='button' class='btn btn-danger btn-lg' onclick='delProject(" + proId + ")' style='padding:5px 10px;margin-right:5px'>删除此项目展示</button>");
                var td5 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
                $("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).appendTo("#member_table");
            });
            //构建分页条
            //当前页的页码
            var pageNum = result.extended.pageInfo.pageNum;
            //总页数
            var pages = result.extended.pageInfo.pages;
            //前一页的页码
            var prePage = result.extended.pageInfo.prePage;
            //后一页的页码
            var nextPage = result.extended.pageInfo.nextPage;
            //是否为第一页
            var isFirstPage = result.extended.pageInfo.isFirstPage;
            //是否为最后一页
            var isLastPage = result.extended.pageInfo.isLastPage;
            //是否有前一页
            var hasPreviousPage = result.extended.pageInfo.hasPreviousPage;
            //是否有后一页
            var hasNextPage = result.extended.pageInfo.hasNextPage;
            //连续显示的页码
            var navigatepageNums = result.extended.pageInfo.navigatepageNums;
            //当前页的按钮
            var pageNum_Btn = $("<span class='read-only'></span>").append(pageNum);
            //前一页的按钮样式
            var previousPic = $("<span aria-hidden='true'></span>").append("&laquo;");
            //后一页的按钮样式
            var nextPic = $("<span aria-hidden='true'></span>").append("&raquo;");
            //判断是否为第一页
            if (isFirstPage) {
                var previous = $("<span></span>").append(previousPic);
                $("<li class='disabled'></li>").append(previous).appendTo(".pagination");
            } else {
                var previous = $("<a href='#' onclick=" + "getAdminProject(" + prePage + ") aria-label='Next'></a>").append(previousPic);
                $("<li></li>").append(previous).appendTo(".pagination");
            }
            //连续显示的页码
            $.each(navigatepageNums, function (each, item) {
                if (pageNum == item) {
                    //当前页
                    var sr_only = $("<span class='sr-only'>(current)</span>")
                    var current_a = $("<a href=#></a>").append(pageNum).append(sr_only);
                    $("<li class='active'></li>").append(current_a).appendTo(".pagination");
                } else {
                    var item_a = $("<a href='#' onclick=" + "getAdminProject(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getAdminProject(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

function project_modal(){
    $("#proUsername").val($("#loginMember").text().substring(4));
    $("#myModal_add").modal('show');
}

//发布项目
function addProject(){
    var formData = new FormData($("#uploadForm")[0]);
    $.ajax({
        type:"POST",
        url:"/adminProject",
        async:false,
        contentType: false,
        processData:false,
        data : formData,
        success:function(result){
            alert(result.msg);
            window.location.reload();
        },
        error:function(result){
            alert(result.msg);
        },
    })
}

//删除一个项目
function delProject(proId){
    if (window.confirm("是否确认删除?")) {
        $.ajax({
            type: "POST",
            url: "/adminProject/" + proId,
            data: {
                _method: "DELETE",
                "awardId": proId
            },
            dataType: "JSON",
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//获取生活照
function getAdminLive() {
    $.ajax({
        type: "GET",
        url: "/adminLive",
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th2 = $("<th></th>").append("生活名称");
            var th3 = $("<th style='text-align:center'></th>").append("生活照片");
            var th4 = $("<th></th>").append("创建人");
            $("<tr></tr>").append(th2).append(th3).append(th4).appendTo("#member_table");
            var memberList = result.extended.lives;
            $.each(memberList, function (each, item) {
                var liveId = item.liveId;
                var liveName = item.liveName;
                var liveUsername = item.liveUsername;
                var photos = item.photos;
                var td1 = $("<td style='display:none'></td>").append(liveId);
                var td2 = $("<td></td>").append(liveName);
                var td3 = $("<td style='text-align:center'></td>");
                $.each(photos, function (each, item) {
                    var img = $("<img src=" + item.photoLoc + " style='width:100px;height:80px;margin-left:5px'>");
                    td3.append(img);
                });
                var td4 = $("<td></td>").append(liveUsername);
                var detail_Btn = $("<button type='button' class='btn btn-danger btn-lg' onclick='delLive(" + liveId + ")' style='padding:5px 10px;margin-right:5px'>删除此项目展示</button>");
                var td5 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
                $("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).appendTo("#member_table");
            });
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

function live_modal(){
    $("#liveUsername").val($("#loginMember").text().substring(4));
    $("#myModal_add").modal('show');
}

//发布生活照片
function addLive(){
    var formData = new FormData();
    var pirctures = document.getElementById("pictures").files;
    if (pirctures.length==0 || pirctures.length > 5){
        alert("最多只能上传五张照片,但是不能一张照片都没有");
    }
    for (var i = 0;i<pirctures.length;i++){
        var file = pirctures[i].name;
        alert(file);
        var index = file.lastIndexOf(".");
        var suffix = file.substring(index);
        if (suffix != ".bmp" && suffix != ".png" && suffix != ".gif" && suffix != ".jpg" && suffix != ".jpeg"){
            alert("只能上传图片!");
            return false;
        }
        var size = pirctures[i].size / (1024 * 1024);
        alert(size);
        if(size > 10){
            alert("不能上传大于10MB的文件！");
            return false;
        }
        formData.append("files",pirctures[i]);
    }
    formData.append("liveName",$("#liveName").val());
    formData.append("liveUsername",$("#liveUsername").val());
    $.ajax({
        type:"POST",
        url:"/adminLive",
        cache: false,
        contentType: false,
        processData: false,
        data : formData,
        success:function(result){
            alert(result.msg);
            window.location.reload();
        },
        error:function(result){
            alert(result.msg);
        },
    })
}

//删除一个生活照片
function delLive(liveId){
    if (window.confirm("是否确认删除?")) {
        $.ajax({
            type: "POST",
            url: "/adminLive/" + liveId,
            data: {
                _method: "DELETE",
                "awardId": liveId
            },
            dataType: "JSON",
            success: function (result) {
                window.location.reload();
            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
}

//获取团队历史
function getAdminHistory() {
    $.ajax({
        type: "GET",
        url: "/adminHistory",
        success: function (result) {
            $("#member_table").empty();
            $(".pagination").empty();
            var th2 = $("<th></th>").append("编辑时间");
            var th3 = $("<th style='text-align:center'></th>").append("团队历史介绍");
            var th4 = $("<th></th>").append("最后修改人");
            $("<tr></tr>").append(th2).append(th3).append(th4).appendTo("#member_table");
            var history = result.extended.history;
            var hisId = history.hisId;
            var hisInfo = history.hisInfo.substr(0, 20);
            var editTime = history.editTime;
            var editName = history.editName;
            var td1 = $("<td style='display:none'></td>").append(hisId);
            var td2 = $("<td></td>").append(editTime);
            var td3 = $("<td style='text-align:center'></td>").append(hisInfo + "......");
            var td4 = $("<td></td>").append(editName);
            var detail_Btn = $("<button type='button' class='btn btn-primary btn-lg' onclick='history_detail(" + hisId + ")' style='padding:5px 10px;margin-right:5px'>查看详情</button>");
                var td5 = $("<td style='text-align:center;float:left'></td>").append(detail_Btn);
            $("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).appendTo("#member_table");
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//团队历史详情
function history_detail(hisId) {
    $.ajax({
        type: "GET",
        url: "/adminHistory/" + hisId,
        data: {
            "hisId": hisId
        },
        success: function (result) {
            var history = result.extended.history;
            var hisId = history.hisId;
            var hisInfo = history.hisInfo;
            var editTime = history.editTime;
            var editName = history.editName;
            $("#hisId").val(hisId);
            $("#hisInfo").val(hisInfo);
            $("#editTime").val(editTime);
            $("#editName").val(editName);
            $("#myModal").modal('show');
        },
        error: function (result) {
            alert(msg);
        }
    });
}

//更新团队历史
function updateHistory(hisId) {
    $.ajax({
        type: "PUT",
        url: "/adminHistory/" + hisId,
        data: $("#form").serialize(),
        success: function (result) {
            alert(result.msg)
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}