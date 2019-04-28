function getMember(pn) {
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
            $("<tr></tr>").append(th1).append(th2).append(th3).append(th4).append(th5).append(th6).append(th7).appendTo("#member_table");
            var memberList = result.extended.pageInfo.list;
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
                $("<tr></tr>").append(td1).append(td8).append(td7).append(td2).append(td3).append(td4).append(td6).append(td5).appendTo("#member_table");
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
                var previous = $("<a href='#' onclick=" + "getMember(" + prePage + ") aria-label='Next'></a>").append(previousPic);
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
                    var item_a = $("<a href='#' onclick=" + "getMember(" + item + ")></a>").append(item);
                    $("<li></li>").append(item_a).appendTo(".pagination");
                }
            });
            //判断是否为最后一页
            if (isLastPage) {
                var Next = $("<span></span>").append(nextPic);
                $("<li class='disabled'></li>").append(Next).appendTo(".pagination");
            } else {
                var next = $("<a href='#' onclick=" + "getMember(" + nextPage + ") aria-label='Next'></a>").append(nextPic);
                $("<li></li>").append(next).appendTo(".pagination");
            }
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}