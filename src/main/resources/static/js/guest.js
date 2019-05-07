//前台获取团队生活照
function getLive() {
    $.ajax({
        type: "GET",
        url: "/guestLive",
        success: function (result) {
            var lives = result.extended.live;
            $.each(lives, function (each, item) {
                var liveName = $("<h1></h1>").append(item.liveName);
                if (item.liveName == "领导视察") {
                    var content = $("<p class='lead'></p>").append(
                        "2018年10月26日傍晚，潘校长百忙之中亲自到9栋111室图灵创新实验室指导和关心我校人工智能团队的创新创业工作。争取把图灵创新团队建设成为海大甚至粤西最强的人工智能学生创新团队，潘校长和蔼可亲地和实验室同学一一握手，并愉快地与同学们合影留念。"
                    );
                } else if (item.liveName == "PRCV") {
                    var content = $("<p class='lead'></p>").append(
                        "2018年11月23日，中国第一届PRCV在广州白云国际会议中心隆重举行。作为图灵智能创新团队骨干之一有幸参加这次的PRCV之旅，PRCV全称为Chinese Conference on Pattern Recognition and Computer Vision(中国模式识别与计算机视觉学术会议)。"
                    );
                }
                var carsouel_caption = $("<div class='carousel-caption'></div>").append(liveName)
                    .append(content);
                var span6 = $("<div class='span6'></div>").append(carsouel_caption);
                var row = $("<div class='row' style='text-align:center'>").append(span6);
                var container = $("<div class='container'></div>").append(row);
                var item_div = $("<div class='item'></div>").append(container).appendTo(
                    "#my-carousel-inner");

                var photo_Num = item.photos.length;
                if (photo_Num == 5 || photo_Num == 6) {
                    $.each(item.photos, function (each1, item1) {
                        var img = $("<img src=" + item1.photoLoc +
                                " style='width:150px;height:150px;margin:5px'>")
                            .appendTo(row);
                    });
                } else if (photo_Num == 2) {
                    $.each(item.photos, function (each1, item1) {
                        var img = $("<img src=" + item1.photoLoc +
                            " style='width:100%;height:230px' margin:auto>").appendTo(
                            row);
                        var imgSpan6 = $("<span class='span4'>").append(img).appendTo(
                            row);
                    });
                } else if (photo_Num == 1) {
                    var img = $("<img src=" + item1.photoLoc +
                            ">")
                        .appendTo(row);
                }
            });
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//前台获取获奖情况
function getAward() {
    $.ajax({
        type: "GET",
        url: "/guestAward",
        success: function (result) {
            var awards = result.extended.award;
            $.each(awards, function (each, item) {
                if (each >= 10) {
                    $("<span class='lead'></span>").append("PS:位置有限，只能放得下10条，勿喷，不是装*，哈哈哈哈~").appendTo("#award");
                    return false;
                } else {
                    var li = $("<li></li>").append(item.awardTime).append(" " + item.awardName);
                    $("<ul></ul>").append(li).appendTo("#award");
                }
            });
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//前台获取最新通告情况
function getInform() {
    $.ajax({
        type: "GET",
        url: "/guestInform",
        success: function (result) {
            var inform = result.extended.inform;
            var createTime = $("<p></p>").append("发布时间:"+inform.createTime);
            var informInfo = $("<p></p>").append("公告:"+inform.informInfo);
            $("#inform").append(createTime).append(informInfo);
        },
        error: function (result) {
            alert(result.msg);
        }
    });
}

//前台获取团队历史介绍内容
function getHistory() {
    $.ajax({
        type: "GET",
        url: "/guestHistory",
        success: function (result) {
            var history = result.extended.history.hisInfo;
            $("#history").append(history);
        },
    })
}

//前台获取团队项目及照片
function getProject() {
    $.ajax({
        type: "GET",
        url: "/guestProject",
        success: function (result) {
            var projectsPhotos = result.extended.projectsPhoto;
            $.each(projectsPhotos, function (each, item) {
                var proName = $("<h1></h1>").append(item.proName);
                var carsouel_caption = $("<div class='carousel-caption'></div>").append(proName);
                var span6 = $("<div class='span6'></div>").append(carsouel_caption);
                var row = $("<div class='row'>").append(span6);
                var container = $("<div class='container'></div>").append(row);
                var item_div = $("<div class='item'></div>").append(container).appendTo(
                    "#my-carousel-inner");
                var photo = item.photo;
                var img = $("<img src=" + photo.photoLoc +
                    " style='width:714px;height:440px'>");
                $("<div class='span6' style='margin-top:20px'></div>").append(img).appendTo(row);
            });
        },  
        error: function (result) {
            alert(result.msg);
        }
    });
}

//前台获取后台成员
function getBackside(){
    $.ajax({
        type:"GET",
        url: "/guestMember/backside",
        dataType:"JSON",
        success:function(result){
            var memberList = result.extended.pageInfo.list;
            $.each(memberList,function(each, item){
                var memberDirect = $("<div></div>").append("学习方向："+item.memberDirect);
                var birthday = $("<div></div>").append("出生日期："+item.birthday);
                var major = $("<div></div>").append("专业班级："+item.major);
                var afterGraduated = $("<div></div>").append("毕业去向："+item.afterGraduated);
                var phoneNumber = $("<div></div>").append("联系方式："+item.phoneNumber);
                var memberName = $("<div></div>").append(item.memberName);
                var body = $("<div class='body'></div>").append(memberName);
                var head = $("<div class='header'></div>").append(memberDirect).append(birthday).append(major).append(afterGraduated).append(phoneNumber);
                var card = $("<div class='card'></div>").append(head).append(body).appendTo(".card-side");
            });
            
        }
    });
}

//前台获取人工智能成员
function getAi(){
    $.ajax({
        type:"GET",
        url: "/guestMember/ai",
        dataType:"JSON",
        success:function(result){
            var memberList = result.extended.pageInfo.list;
            $.each(memberList,function(each, item){
                var memberDirect = $("<div></div>").append("学习方向："+item.memberDirect);
                var birthday = $("<div></div>").append("出生日期："+item.birthday);
                var major = $("<div></div>").append("专业班级："+item.major);
                var afterGraduated = $("<div></div>").append("毕业去向："+item.afterGraduated);
                var phoneNumber = $("<div></div>").append("联系方式："+item.phoneNumber);
                var memberName = $("<div></div>").append(item.memberName);
                var body = $("<div class='body'></div>").append(memberName);
                var head = $("<div class='header'></div>").append(memberDirect).append(birthday).append(major).append(afterGraduated).append(phoneNumber);
                var card = $("<div class='card'></div>").append(head).append(body).appendTo(".card-side");
            });
            
        }
    });
}

//前台获取前端成员
function getFrontside(){
    $.ajax({
        type:"GET",
        url: "/guestMember/frontside", 
        dataType:"JSON",
        success:function(result){
            var memberList = result.extended.pageInfo.list;
            $.each(memberList,function(each, item){
                var memberDirect = $("<div></div>").append("学习方向："+item.memberDirect);
                var birthday = $("<div></div>").append("出生日期："+item.birthday);
                var major = $("<div></div>").append("专业班级："+item.major);
                var afterGraduated = $("<div></div>").append("毕业去向："+item.afterGraduated);
                var phoneNumber = $("<div></div>").append("联系方式："+item.phoneNumber);
                var memberName = $("<div></div>").append(item.memberName);
                var body = $("<div class='body'></div>").append(memberName);
                var head = $("<div class='header'></div>").append(memberDirect).append(birthday).append(major).append(afterGraduated).append(phoneNumber);
                var card = $("<div class='card'></div>").append(head).append(body).appendTo(".card-side");
            });
            
        }
    });
}