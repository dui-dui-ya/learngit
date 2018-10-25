/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2018/10/16 15:15:55                          */
/*==============================================================*/


alter table d_address
   drop constraint FK_D_ADDRES_REFERENCE_D_USER;

alter table d_book
   drop constraint FK_D_BOOK_REFERENCE_D_CATEGO;

alter table d_order
   drop constraint FK_D_ORDER_REFERENCE_D_ADDRES;

alter table d_order
   drop constraint FK_D_ORDER_REFERENCE_D_USER;

alter table d_orderIterm
   drop constraint FK_D_ORDERI_REFERENCE_D_ORDER;

alter table d_orderIterm
   drop constraint FK_D_ORDERI_REFERENCE_D_BOOK;

drop table d_address cascade constraints;

drop table d_book cascade constraints;

drop table d_category cascade constraints;

drop table d_order cascade constraints;

drop table d_orderIterm cascade constraints;

drop table d_user cascade constraints;

/*==============================================================*/
/* Table: d_address                                             */
/*==============================================================*/
create table d_address  (
   id                   NUMBER(20)                      not null,
   name                 VARCHAR2(20)                    not null,
   detail_address       VARCHAR2(100)                   not null,
   zipcode              VARCHAR2(20)                    not null,
   telphone             VARCHAR2(20),
   addr_mobile          VARCHAR2(20),
   user_id              NUMBER(20)                      not null,
   constraint PK_D_ADDRESS primary key (id)
);
create sequence d_address_seq;
insert into d_address values(d_address_seq.nextval,'duidui','地球村中国北京市鸟巢','10001','18001356700','18001356701',1);
insert into d_address values(d_address_seq.nextval,'duidui','地球村中国北京市八宝山','10001','18001356700','18001356701',1);
select id as addressId,name as name,detail_address as detailAddress,zipcode as zipcode,
			telphone as telphone,addr_mobile as addrMobile,user_id as userId
		from d_address
/*==============================================================*/
/* Table: d_book                                                */
/*==============================================================*/
create table d_book  (
   book_id              NUMBER(12)                      not null,
   book_name            VARCHAR2(128)                   not null,
   book_author          VARCHAR2(64)                    not null,
   book_publish         VARCHAR2(128)                   not null,
   publish_time         DATE,
   revision             integer,
   book_isbn            varchar2(64),
   word_count           varchar2(64),
   page_count           integer,
   open_type            varchar2(20),
   book_paper           VARCHAR2(64),
   book_wrapper         varchar2(64),
   book_category        NUMBER(11),
   book_price           NUMBER(10,2),
   book_dprice          NUMBER(10,2),
   editor_recommendation varchar2(2000),
   content_introduction varchar2(2000),
   author_introduction  varchar2(2000),
   menu                 varchar2(2000),
   media_review         varchar2(2000),
   digest_image_path    varchar2(2000),
   product_image_path   varchar2(2000),
   series_name          varchar2(128),
   printing_time        date,
   impression           varchar2(64),
   stock                integer,
   shelves_date         date,
   customer_socre       number(3,2),
   book_status          NUMBER(1),
   sales                NUMBER(10),
   constraint PK_D_BOOK primary key (book_id)
);
insert into d_book values(1,'一个陌生女人的来信','张能能','最小说',to_Date('2000-11-11','yyyy-MM-dd'),1,'12345678','1万',100,'16开','胶版纸','平装',012,200.0,180.0,
	'在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！'||
	'-―玛丽娅•蒙台梭利（本书作者）'||
	'今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！'||
　	'――塞吉（玛丽娅•蒙台梭利博士的老师）'||
	'蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。'||
　　' ――E•G•霍尔姆斯（哈佛大学教育学院教授）',
	'一个陌生女人的来信','能能作者简介','emmm啥也没有的目录','好，非常畅销!难得的一本好书',
	'第2章 对教育方法的历史回顾'||
　　'儿童之家使用的教育体系实际上已经向前迈出了一大步。假如人们认为我和正常儿童相处所得的经验相对短暂，那么此经验建立在以往对非正常儿童的教育经验基础之上，因此也代表着一段相当长期的思想。'||
　　'假如我们想开发出科学的教育体系，就必须开辟出一条前所未有的新路。教师们必须接受专业培训，同时而学校也必须进行转变。假如教师们都接受了观察与实验的培训，那他们必须在学校里执行这些活动。'||
　　'因此，科学教育体系的基本需求是有一个能允许儿童自由发展个性的学校。如果某种教育体系是基于对学生个体的研究，那么其研究方式应该是对行动自由的儿童进行观察和研究，而不是对一个受压制的学生进行观察和研究。'||
　　'在人类学和实验心理学的帮助下，在一个人应试教育为主的学校里，开发新型教育方法，是最愚蠢的想法。'||
　　'每个领域的实验科学，都是由使用自己独特的方法中发展而来。细菌学起源于分离并培育微生物。犯罪学、医学和教育学也都分别在不同类型的个体上使用过最初的人体测量方法，如在罪犯上、精神病人、医院里的临床病人、学生身上等。实验心理学在开始阶段就要指出执行实验的精确技术。',
	'16.jpg','一个陌生女人的来信-丛书名',to_Date('2010-11-11','yyyy-MM-dd'),'100',50,to_Date('2005-11-11','yyyy-MM-dd'),7.8,1,50);
insert into d_book values(2,'简·爱','张能能','最小说',to_Date('2000-11-11','yyyy-MM-dd'),1,'12345678','1万',100,'16开','胶版纸','平装',011,200.0,180.0,
	'在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！'||
	'-―玛丽娅•蒙台梭利（本书作者）'||
	'今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！'||
　	'――塞吉（玛丽娅•蒙台梭利博士的老师）'||
	'蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。'||
　　' ――E•G•霍尔姆斯（哈佛大学教育学院教授）',
	'一个陌生女人的来信','能能作者简介','emmm啥也没有的目录','好，非常畅销!难得的一本好书',
	'第2章 对教育方法的历史回顾'||
　　'儿童之家使用的教育体系实际上已经向前迈出了一大步。假如人们认为我和正常儿童相处所得的经验相对短暂，那么此经验建立在以往对非正常儿童的教育经验基础之上，因此也代表着一段相当长期的思想。'||
　　'假如我们想开发出科学的教育体系，就必须开辟出一条前所未有的新路。教师们必须接受专业培训，同时而学校也必须进行转变。假如教师们都接受了观察与实验的培训，那他们必须在学校里执行这些活动。'||
　　'因此，科学教育体系的基本需求是有一个能允许儿童自由发展个性的学校。如果某种教育体系是基于对学生个体的研究，那么其研究方式应该是对行动自由的儿童进行观察和研究，而不是对一个受压制的学生进行观察和研究。'||
　　'在人类学和实验心理学的帮助下，在一个人应试教育为主的学校里，开发新型教育方法，是最愚蠢的想法。'||
　　'每个领域的实验科学，都是由使用自己独特的方法中发展而来。细菌学起源于分离并培育微生物。犯罪学、医学和教育学也都分别在不同类型的个体上使用过最初的人体测量方法，如在罪犯上、精神病人、医院里的临床病人、学生身上等。实验心理学在开始阶段就要指出执行实验的精确技术。',
	'6.jpg','简·爱-丛书名',to_Date('2010-11-11','yyyy-MM-dd'),'100',40,to_Date('2005-11-11','yyyy-MM-dd'),7.8,1,60);
delete from d_book where book_id=1;
insert into d_book values(3,'双螺旋','张能能','最小说',to_Date('2000-11-11','yyyy-MM-dd'),1,'12345678','1万',100,'16开','胶版纸','平装',011,200.0,180.0,
	'在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！'||
	'-―玛丽娅•蒙台梭利（本书作者）'||
	'今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！'||
　	'――塞吉（玛丽娅•蒙台梭利博士的老师）'||
	'蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。'||
　　' ――E•G•霍尔姆斯（哈佛大学教育学院教授）',
	'双螺旋','能能作者简介','emmm啥也没有的目录','好，非常畅销!难得的一本好书',
	'第2章 对教育方法的历史回顾'||
　　'儿童之家使用的教育体系实际上已经向前迈出了一大步。假如人们认为我和正常儿童相处所得的经验相对短暂，那么此经验建立在以往对非正常儿童的教育经验基础之上，因此也代表着一段相当长期的思想。'||
　　'假如我们想开发出科学的教育体系，就必须开辟出一条前所未有的新路。教师们必须接受专业培训，同时而学校也必须进行转变。假如教师们都接受了观察与实验的培训，那他们必须在学校里执行这些活动。'||
　　'因此，科学教育体系的基本需求是有一个能允许儿童自由发展个性的学校。如果某种教育体系是基于对学生个体的研究，那么其研究方式应该是对行动自由的儿童进行观察和研究，而不是对一个受压制的学生进行观察和研究。'||
　　'在人类学和实验心理学的帮助下，在一个人应试教育为主的学校里，开发新型教育方法，是最愚蠢的想法。'||
　　'每个领域的实验科学，都是由使用自己独特的方法中发展而来。细菌学起源于分离并培育微生物。犯罪学、医学和教育学也都分别在不同类型的个体上使用过最初的人体测量方法，如在罪犯上、精神病人、医院里的临床病人、学生身上等。实验心理学在开始阶段就要指出执行实验的精确技术。',
	'5.jpg','双螺旋-丛书名',to_Date('2010-11-11','yyyy-MM-dd'),'100',60,to_Date('2005-11-11','yyyy-MM-dd'),7.8,1,40);
delete from d_book where book_id=1;
update d_book set shelves_date=to_Date('2004-10-10','yyyy-MM-dd') where book_id=1;

update d_book set shelves_date=to_Date('2006-12-12','yyyy-MM-dd') where book_id=3;
select * from d_book;
select book_name as bookName,product_image_path as productImagePath,
			book_author as bookAuthor,book_publish as bookPublish,publish_time as publishTime,
			book_price as bookPrice,book_dprice as bookDprice
		from d_book
		where book_category = 001;
select * 
from(select book_id as bookId, book_name as bookName,book_author as bookAuthor,book_publish as bookPublish,
			publish_time as publishTime,revision as revision,word_count as wordCount,
			page_count as pageCount,open_type as openType,book_paper as bookPaper,book_wrapper as bookWrapper,
			
			book_price as bookPrice,book_dprice as bookDprice,
			product_image_path as productImagePath,printing_time as printingTime,impression as impression,
			book_isbn as bookIsbn,editor_recommendation as editorRecommendation,content_introduction as contentIntroduction,
			author_introduction as authorIntroduction,menu as menu,media_review as mediaReview,
			digest_image_path as digestImagePath,rownum as rn
			from d_book
			where sales is not null and shelves_date is not null
			order by sales desc,shelves_date desc)
where rn <=8;
--select book_name as bookName,product_image_path as productImagePath,
	--		book_price as bookPrice,book_dprice as bookDprice
		--from d_book 
		--where shelves_date is not null
		--order by shelves_date desc
/*==============================================================*/
/* Table: d_category                                            */
/*==============================================================*/
create table d_category  (
   category_id          NUMBER(20)                      not null,
   category_name        VARCHAR(20)                     not null,
   book_counts          NUMBER(10),
   category_pid         NUMBER(20),
   constraint PK_D_CATEGORY primary key (category_id)
);
select * from d_category;
select c.category_id as cateId,c.category_name as cateName,p.category_id as pcateId,
			p.category_name as pcateName,p.book_counts as bookCount
		from d_category c left join d_category p
		on c.category_id=p.category_pid
select c.category_id as cateId,c.category_name as cateName,p.category_id as pcateId,
			p.category_name as pcateName,p.book_counts as bookCount
		from d_category c right join d_category p
		on c.category_id=p.category_pid
		
		--where c.category_id=001 
		
		where c.category_id=1 or c.category_id=
		(select category_pid as catePid
		from d_category
		where category_id=1);
		
select *
from (select c.category_id as cateId,c.category_name as cateName,p.category_id as pcateId,
			p.category_name as pcateName,p.book_counts as bookCount,rownum as rn
		from d_category c left join d_category p on c.category_id=p.category_pid
		where p.book_counts is not null
		order by p.book_counts desc)
where rn <= 4;

		select count(*)from
		(select c.category_id as cateId,c.category_name as cateName,p.category_id as pcateId,
			p.book_counts as bookCount,
			d.book_id as bookId,d.book_Name as bookName,d.customer_socre as customerSocre,d.book_author as bookAuthor,
			d.book_publish as bookPublish,d.publish_Time as publishTime,d.media_Review as mediaReview,
			d.book_price as bookPrice,d.book_Dprice as bookDpric,d.shelves_date as shelvesDate
		 --select count(*)
		from d_category c left join d_category p
		on c.category_id=p.category_pid
		left join d_book d
		on p.category_id = d.book_category
		where d.book_Name is not null and c.category_id=1  or p.category_id =1
		order by d.shelves_date asc)
		where bookName is not null
		
insert into d_category values(001,'小说',30,null);
insert into d_category values(011,'近现代小说',15,001);
insert into d_category values(012,'当代小说',10,001);
insert into d_category values(013,'古典小说',5,001);
insert into d_category values(002,'青春',20,null);
insert into d_category values(022,'校园',14,002);
insert into d_category values(023,'玄幻',6,002);


/*==============================================================*/
/* Table: d_order                                               */
/*==============================================================*/
create table d_order  (
   id                   NUMBER(20)                      not null,
   num                  varchar2(40),
   create_date          date,
   price                NUMBER(8,2),
   order_addrid         NUMBER(20)                      not null,
   order_uid            NUMBER(20)                      not null,
   status               NUMBER(1),
   constraint PK_D_ORDER primary key (id)
);
alter table d_order modify num varchar2(40);
create sequence d_order_seq;
select id as orderId,num as num,create_date as createDate,price as price,
			order_addrId as orderAddrId,order_uid as orderUid,status as status 
		from d_order
/*==============================================================*/
/* Table: d_orderIterm                                          */
/*==============================================================*/
create table d_orderItem  (
   shop_id              NUMBER(20)                      not null,
   shop_bookid          varchar2(40)                      not null,
   shop_ordid           NUMBER(20)                      ,
   shop_num             NUMBER(20)                      not null,
   total_price          NUMBER(8,2),
   constraint PK_D_ORDERITERM primary key (shop_id)
);
alter table d_orderItem modify shop_bookid number(20);
commit;
create sequence d_orderItem_seq;
select shop_id as shopId,shop_bookid as shopBookId,shop_ordId as shopOrdId,
			shop_num as shopoNum,total_price as totalPrice
		from d_orderItem
/*==============================================================*/
/* Table: d_user                                                */
/*==============================================================*/
create table d_user  (
   user_id              NUMBER(20)                      not null,
   user_email           VARCHAR2(50),
   user_password        VARCHAR2(20),
   user_name            VARCHAR(30),
   user_status          NUMBER(1),
   constraint PK_D_USER primary key (user_id)
);
create sequence d_user_seq;

select * from d_user;
select user_id as userId,user_email as userEmail,user_password as userPassword,
			user_name as userName, user_status as userStatus
		from d_user
