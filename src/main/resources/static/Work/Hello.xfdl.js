(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Emp");
            this.set_titletext("Employees");
            if (Form == this.constructor)
            {
                this._setFormPosition(1000,700);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_emp", this);
            obj.set_keystring("");
            obj._setContents("<ColumnInfo><Column id=\"EMPL_ID\" type=\"STRING\" size=\"10\"/><Column id=\"FULL_NAME\" type=\"STRING\" size=\"50\"/><Column id=\"DEPT_CD\" type=\"STRING\" size=\"10\"/><Column id=\"POS_CD\" type=\"STRING\" size=\"10\"/><Column id=\"HIRE_DATE\" type=\"DATE\" size=\"10\"/><Column id=\"SALARY\" type=\"INT\" size=\"10\"/><Column id=\"GENDER\" type=\"STRING\" size=\"10\"/><Column id=\"MARRIED\" type=\"STRING\" size=\"10\"/><Column id=\"MEMO\" type=\"STRING\" size=\"10\"/></ColumnInfo><Rows><Row><Col id=\"EMPL_ID\">AA001</Col><Col id=\"FULL_NAME\">Olivia</Col><Col id=\"DEPT_CD\">01</Col><Col id=\"POS_CD\">03</Col><Col id=\"HIRE_DATE\">20101003</Col><Col id=\"SALARY\">83000</Col><Col id=\"GENDER\">W</Col><Col id=\"MARRIED\">true</Col><Col id=\"MEMO\">ivory</Col></Row><Row><Col id=\"EMPL_ID\">AA002</Col><Col id=\"FULL_NAME\">John</Col><Col id=\"DEPT_CD\">02</Col><Col id=\"POS_CD\">04</Col><Col id=\"HIRE_DATE\">20051011</Col><Col id=\"SALARY\">76000</Col><Col id=\"GENDER\">M</Col><Col id=\"MARRIED\">false</Col><Col id=\"MEMO\">greenyellow</Col></Row><Row><Col id=\"EMPL_ID\">BB001</Col><Col id=\"FULL_NAME\">Jackson</Col><Col id=\"DEPT_CD\">03</Col><Col id=\"POS_CD\">03</Col><Col id=\"HIRE_DATE\">20070206</Col><Col id=\"SALARY\">95000</Col><Col id=\"GENDER\">M</Col><Col id=\"MARRIED\">true</Col><Col id=\"MEMO\">aliceblue</Col></Row><Row><Col id=\"EMPL_ID\">BB002</Col><Col id=\"FULL_NAME\">Maia</Col><Col id=\"DEPT_CD\">04</Col><Col id=\"POS_CD\">02</Col><Col id=\"HIRE_DATE\">20090512</Col><Col id=\"SALARY\">60000</Col><Col id=\"GENDER\">W</Col><Col id=\"MARRIED\">false</Col><Col id=\"MEMO\">ivory</Col></Row><Row><Col id=\"EMPL_ID\">CC001</Col><Col id=\"FULL_NAME\">Adam</Col><Col id=\"DEPT_CD\">01</Col><Col id=\"POS_CD\">04</Col><Col id=\"HIRE_DATE\">20010109</Col><Col id=\"SALARY\">88000</Col><Col id=\"GENDER\">M</Col><Col id=\"MARRIED\">true</Col><Col id=\"MEMO\">greenyellow</Col></Row><Row><Col id=\"EMPL_ID\">DD001</Col><Col id=\"FULL_NAME\">Ray</Col><Col id=\"DEPT_CD\">02</Col><Col id=\"POS_CD\">03</Col><Col id=\"HIRE_DATE\">20160202</Col><Col id=\"SALARY\">60000</Col><Col id=\"GENDER\">M</Col><Col id=\"MARRIED\">true</Col><Col id=\"MEMO\">lightpink</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_pos", this);
            obj._setContents("<ColumnInfo><Column id=\"POS_CD\" type=\"string\" size=\"32\"/><Column id=\"POS_NAME\" type=\"string\" size=\"32\"/></ColumnInfo><Rows><Row><Col id=\"POS_CD\">04</Col><Col id=\"POS_NAME\">Officer</Col></Row><Row><Col id=\"POS_CD\">03</Col><Col id=\"POS_NAME\">Assistant Manager</Col></Row><Row><Col id=\"POS_CD\">02</Col><Col id=\"POS_NAME\">Division Manager</Col></Row><Row><Col id=\"POS_CD\">01</Col><Col id=\"POS_NAME\">Chairman</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_dept", this);
            obj._setContents("<ColumnInfo><Column id=\"DEPT_CD\" type=\"STRING\" size=\"32\"/><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"32\"/></ColumnInfo><Rows><Row><Col id=\"DEPT_CD\">01</Col><Col id=\"DEPT_NAME\">Accounting Team</Col></Row><Row><Col id=\"DEPT_CD\">02</Col><Col id=\"DEPT_NAME\">HR Team</Col></Row><Row><Col id=\"DEPT_CD\">03</Col><Col id=\"DEPT_NAME\">Sales Team</Col></Row><Row><Col id=\"DEPT_CD\">04</Col><Col id=\"DEPT_NAME\">Design Team</Col></Row><Row><Col id=\"DEPT_CD\">05</Col><Col id=\"DEPT_NAME\">Education Team</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_hand", this);
            obj.set_dataobjectpath("$");
            obj._setContents("<ColumnInfo><Column id=\"Dept_CD\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"dept_ID\" type=\"STRING\" size=\"256\"/><Column id=\"FULL__NAME\" type=\"STRING\" size=\"256\"/><Column id=\"SALARY\" type=\"INT\" size=\"256\"/><Column id=\"GENDER\" type=\"STRING\" size=\"256\"/><Column id=\"MEMO\" type=\"STRING\" size=\"256\"/><Column id=\"HIRE_DATE\" type=\"DATE\" size=\"256\"/><Column id=\"MARRIED\" type=\"STRING\" size=\"256\"/><Column id=\"POS_NAME\" type=\"STRING\" size=\"256\"/><Column id=\"POS_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"deptCd\" datapath=\"@[0].deptCd\" type=\"STRING\" size=\"256\"/><Column id=\"deptName\" datapath=\"@[0].deptName\" type=\"STRING\" size=\"256\"/><Column id=\"deptId\" datapath=\"@[0].deptId\" type=\"STRING\" size=\"256\"/><Column id=\"fullName\" datapath=\"@[0].fullName\" type=\"STRING\" size=\"256\"/><Column id=\"salary\" datapath=\"@[0].salary\" type=\"STRING\" size=\"256\"/><Column id=\"gender\" datapath=\"@[0].gender\" type=\"STRING\" size=\"256\"/><Column id=\"memo\" datapath=\"@[0].memo\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" datapath=\"@[0].hireDate\" type=\"STRING\" size=\"256\"/><Column id=\"married\" datapath=\"@[0].married\" type=\"STRING\" size=\"256\"/><Column id=\"posName\" datapath=\"@[0].posName\" type=\"STRING\" size=\"256\"/><Column id=\"posCode\" datapath=\"@[0].posCode\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Dept_CD\">100</Col><Col id=\"DEPT_NAME\">컴퓨터과학</Col><Col id=\"dept_ID\">AA001</Col><Col id=\"FULL__NAME\">제이지</Col><Col id=\"SALARY\">2500000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2023-03-01</Col><Col id=\"MEMO\">우수한 인재</Col><Col id=\"POS_NAME\">학생</Col><Col id=\"POS_CODE\">02</Col></Row><Row><Col id=\"Dept_CD\">200</Col><Col id=\"DEPT_NAME\">생명공학</Col><Col id=\"dept_ID\">BB022</Col><Col id=\"FULL__NAME\">홍길동</Col><Col id=\"SALARY\">2300000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2025-01-01</Col><Col id=\"MEMO\">우수한 인재</Col><Col id=\"POS_NAME\">교수</Col><Col id=\"POS_CODE\">01</Col></Row><Row><Col id=\"Dept_CD\">300</Col><Col id=\"DEPT_NAME\">전기공학</Col><Col id=\"dept_ID\">CC033</Col><Col id=\"FULL__NAME\">이순신</Col><Col id=\"SALARY\">1800000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2022-01-05</Col><Col id=\"MEMO\">이렇게 해보기</Col><Col id=\"POS_NAME\">학생</Col><Col id=\"POS_CODE\">02</Col></Row><Row><Col id=\"Dept_CD\">400</Col><Col id=\"DEPT_NAME\">의과</Col><Col id=\"dept_ID\">DD044</Col><Col id=\"FULL__NAME\">그레이스</Col><Col id=\"SALARY\">2000000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2023-05-01</Col><Col id=\"MEMO\">메모를 채워보기</Col><Col id=\"POS_NAME\">학생</Col><Col id=\"POS_CODE\">02</Col></Row><Row><Col id=\"Dept_CD\">500</Col><Col id=\"DEPT_NAME\">한의과</Col><Col id=\"dept_ID\">EE055</Col><Col id=\"FULL__NAME\">김지훈</Col><Col id=\"SALARY\">2000000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2022-05-06</Col><Col id=\"MEMO\">이름을 잘보기</Col><Col id=\"POS_NAME\">학생</Col><Col id=\"POS_CODE\">02</Col></Row><Row><Col id=\"Dept_CD\">600</Col><Col id=\"DEPT_NAME\">연극영화과</Col><Col id=\"dept_ID\">FF006</Col><Col id=\"FULL__NAME\">김지나</Col><Col id=\"SALARY\">3500000</Col><Col id=\"GENDER\">W</Col><Col id=\"HIRE_DATE\">2010-12-11</Col><Col id=\"MEMO\">메모가 작동함</Col><Col id=\"POS_NAME\">교수</Col><Col id=\"POS_CODE\">01</Col></Row><Row><Col id=\"Dept_CD\">700</Col><Col id=\"DEPT_NAME\">국어국문과</Col><Col id=\"dept_ID\">GG007</Col><Col id=\"FULL__NAME\">조용필</Col><Col id=\"SALARY\">4000000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">2022-01-22</Col><Col id=\"MEMO\">아무것도 모르겠음</Col><Col id=\"POS_NAME\">교수</Col><Col id=\"POS_CODE\">01</Col></Row><Row><Col id=\"Dept_CD\">100</Col><Col id=\"DEPT_NAME\">영화과</Col><Col id=\"dept_ID\">AA005</Col><Col id=\"FULL__NAME\">이연희</Col><Col id=\"SALARY\">2100000</Col><Col id=\"GENDER\">W</Col><Col id=\"HIRE_DATE\">2024-03-15</Col><Col id=\"MEMO\">넥사크로</Col><Col id=\"POS_NAME\">조교</Col><Col id=\"POS_CODE\">03</Col></Row><Row><Col id=\"Dept_CD\">100</Col><Col id=\"DEPT_NAME\">천체물리학과</Col><Col id=\"dept_ID\">Ab001</Col><Col id=\"FULL__NAME\">감우성</Col><Col id=\"SALARY\">7000000</Col><Col id=\"GENDER\">M</Col><Col id=\"HIRE_DATE\">1990-03-02</Col><Col id=\"MEMO\">회사에 도움 됨</Col><Col id=\"POS_NAME\">학장</Col><Col id=\"POS_CODE\">04</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_handDept", this);
            obj._setContents("<ColumnInfo><Column id=\"DEPT_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"DEPT_NAME\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"DEPT_CODE\">01</Col><Col id=\"DEPT_NAME\">컴퓨터과학</Col></Row><Row><Col id=\"DEPT_CODE\">02</Col><Col id=\"DEPT_NAME\">생명공학</Col></Row><Row><Col id=\"DEPT_CODE\">03</Col><Col id=\"DEPT_NAME\">전기공학</Col></Row><Row><Col id=\"DEPT_CODE\">04</Col><Col id=\"DEPT_NAME\">의과</Col></Row><Row><Col id=\"DEPT_NAME\">한의과</Col></Row><Row><Col id=\"DEPT_NAME\">국어국문과</Col></Row><Row><Col id=\"DEPT_NAME\">영화과</Col></Row><Row><Col id=\"DEPT_NAME\">천체물리학과</Col></Row><Row><Col id=\"DEPT_NAME\">연극영화과</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_position", this);
            obj._setContents("<ColumnInfo><Column id=\"POS_CODE\" type=\"STRING\" size=\"256\"/><Column id=\"POS_NAME\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"POS_CODE\">01</Col><Col id=\"POS_NAME\">교수</Col></Row><Row><Col id=\"POS_CODE\">02</Col><Col id=\"POS_NAME\">학생</Col></Row><Row><Col id=\"POS_CODE\">03</Col><Col id=\"POS_NAME\">조교</Col></Row><Row><Col id=\"POS_CODE\">04</Col><Col id=\"POS_NAME\">학장</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_nexa", this);
            obj._setContents("");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("div_search","10","50",null,"60","10",null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Edit("edt_dept_cd","134","15","68","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("0");
            this.div_search.addChild(obj.name, obj);

            obj = new Button("btn_dept","202","15","30","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_verticalAlign("");
            obj.set_cssclass("btn_WF_Search");
            this.div_search.addChild(obj.name, obj);

            obj = new Edit("edt_dept_nm","232","15","144","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("2");
            this.div_search.addChild(obj.name, obj);

            obj = new Radio("rdo_gender","543","15","252","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("3");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_columncount("-1");
            obj.set_rowcount("-1");
            var div_search_form_rdo_gender_innerdataset = new nexacro.NormalDataset("div_search_form_rdo_gender_innerdataset", obj);
            div_search_form_rdo_gender_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">A</Col><Col id=\"datacolumn\">All</Col></Row><Row><Col id=\"codecolumn\">M</Col><Col id=\"datacolumn\">Male</Col></Row><Row><Col id=\"codecolumn\">W</Col><Col id=\"datacolumn\">Female</Col></Row></Rows>");
            obj.set_innerdataset(div_search_form_rdo_gender_innerdataset);
            obj.set_index("0");
            this.div_search.addChild(obj.name, obj);

            obj = new Button("btn_reset",null,"15","60","30","10",null,null,null,null,null,this.div_search.form);
            obj.set_taborder("4");
            obj.set_text("reset");
            this.div_search.addChild(obj.name, obj);

            obj = new Static("Static04","456","15","87","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("5");
            obj.set_text("Gender");
            obj.set_cssclass("sta_WF_LabelTxt");
            this.div_search.addChild(obj.name, obj);

            obj = new Static("Static00","10","15","124","30",null,null,null,null,null,null,this.div_search.form);
            obj.set_taborder("6");
            obj.set_text("Department");
            obj.set_cssclass("sta_WF_LabelTxt");
            this.div_search.addChild(obj.name, obj);

            obj = new Static("st_title","10","8","193","30",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("핸드소프트");
            obj.set_cssclass("sta_WF_FrmTitle");
            this.addChild(obj.name, obj);

            obj = new Button("btn_retrieve",null,"10","84","30","265",null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Retrieve");
            obj.set_cssclass("btn_WF_CRUD");
            this.addChild(obj.name, obj);

            obj = new Button("btn_add",null,"10","80","30","180",null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("Add");
            obj.set_cssclass("btn_WF_CRUD");
            this.addChild(obj.name, obj);

            obj = new Button("btn_del",null,"10","80","30","95",null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("Delete");
            obj.set_cssclass("btn_WF_CRUD");
            this.addChild(obj.name, obj);

            obj = new Button("btn_save",null,"10","80","30","10",null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("Save");
            obj.set_cssclass("btn_WF_CRUD");
            this.addChild(obj.name, obj);

            obj = new Div("div_detail",null,"115","390",null,"10","10",null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("Div00");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","138","12","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("8");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static01","138","53","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("9");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static09","138","89","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("11");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static15","138","135","240","132",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("16");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static17","138","266","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("18");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static13","138","307","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("14");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static20","138","348","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("5");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static04","138","389","240","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("22");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static07","138","430","240","132",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("24");
            obj.set_text("");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailArea");
            this.div_detail.addChild(obj.name, obj);

            obj = new Edit("edt_name","144","18","226","30",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("0");
            this.div_detail.addChild(obj.name, obj);

            obj = new MaskEdit("msk_id","144","59","226","30",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("1");
            obj.set_type("string");
            obj.set_format("AA###");
            this.div_detail.addChild(obj.name, obj);

            obj = new Combo("cbo_dept","144","100","226","30",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("2");
            obj.set_innerdataset("ds_handDept");
            obj.set_codecolumn("DEPT_NAME");
            obj.set_datacolumn("DEPT_NAME");
            obj.set_text("");
            obj.set_value("");
            obj.set_index("-1");
            this.div_detail.addChild(obj.name, obj);

            obj = new ListBox("lst_pos","144","141","226","120",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("3");
            obj.set_innerdataset("ds_position");
            obj.set_codecolumn("POS_CODE");
            obj.set_datacolumn("POS_NAME");
            this.div_detail.addChild(obj.name, obj);

            obj = new CheckBox("chk_married","144","313","226","30",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("4");
            this.div_detail.addChild(obj.name, obj);

            obj = new TextArea("txt_memo","144","435","226","120",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("7");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static08","9","89","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("10");
            obj.set_text("학과");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static10","9","12","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("12");
            obj.set_text("이름");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailEssential");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static12","9","348","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("13");
            obj.set_text("Hire Date");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailEssential");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static14","9","135","130","132",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("15");
            obj.set_text("Position");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static16","9","266","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("17");
            obj.set_text("성별");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static19","9","389","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("19");
            obj.set_text("Annual Salary");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static00","9","53","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("20");
            obj.set_text("학과ID");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailEssential");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static03","9","307","130","42",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("21");
            obj.set_text("Married");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static05","9","430","130","132",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("23");
            obj.set_text("Memo");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailLabel");
            this.div_detail.addChild(obj.name, obj);

            obj = new MaskEdit("msk_salary","144","395","226","30",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("6");
            obj.set_type("number");
            obj.set_format("#,###.00");
            this.div_detail.addChild(obj.name, obj);

            obj = new Radio("Radio00","142","271","221","34",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("25");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_columncount("3");
            obj.set_direction("horizontal");
            var div_detail_form_Radio00_innerdataset = new nexacro.NormalDataset("div_detail_form_Radio00_innerdataset", obj);
            div_detail_form_Radio00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">M</Col><Col id=\"datacolumn\">남자</Col></Row><Row><Col id=\"codecolumn\">W</Col><Col id=\"datacolumn\">여자</Col></Row><Row><Col id=\"codecolumn\">E</Col><Col id=\"datacolumn\">기타</Col></Row></Rows>");
            obj.set_innerdataset(div_detail_form_Radio00_innerdataset);
            this.div_detail.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","144","357","227","32",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("26");
            this.div_detail.addChild(obj.name, obj);

            obj = new Static("Static06","373","397","15","28",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("27");
            obj.set_text("원");
            this.div_detail.addChild(obj.name, obj);

            obj = new Calendar("Calendar01","181","318","171","27",null,null,null,null,null,null,this.div_detail.form);
            obj.set_taborder("28");
            this.div_detail.addChild(obj.name, obj);

            obj = new Grid("Grid00","19","115","561","388",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_binddataset("ds_hand");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/><Row size=\"24\" band=\"summ\"/></Rows><Band id=\"head\"><Cell text=\"Dept_CD\"/><Cell col=\"1\" text=\"DEPT_NAME\"/><Cell col=\"2\" text=\"dept_ID\"/><Cell col=\"3\" text=\"FULL__NAME\"/><Cell col=\"4\" text=\"SALARY\"/><Cell col=\"5\" text=\"GENDER\"/><Cell col=\"6\" text=\"MEMO\"/><Cell col=\"7\" text=\"HIRE_DATE\"/><Cell col=\"8\" text=\"MARRIED\"/><Cell col=\"9\" text=\"POS_NAME\"/><Cell col=\"10\" text=\"POS_CODE\"/></Band><Band id=\"body\"><Cell text=\"bind:Dept_CD\"/><Cell col=\"1\" text=\"bind:DEPT_NAME\"/><Cell col=\"2\" text=\"bind:dept_ID\" displaytype=\"mask\" edittype=\"mask\" maskeditformat=\"AA-###\" maskedittype=\"string\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:FULL__NAME\"/><Cell col=\"4\" text=\"bind:SALARY\"/><Cell col=\"5\" text=\"bind:GENDER\"/><Cell col=\"6\" text=\"bind:MEMO\"/><Cell col=\"7\" text=\"bind:HIRE_DATE\"/><Cell col=\"8\" text=\"bind:MARRIED\"/><Cell col=\"9\" text=\"bind:POS_NAME\"/><Cell col=\"10\" text=\"bind:POS_CODE\"/></Band><Band id=\"summary\"><Cell/><Cell col=\"1\"/><Cell col=\"2\"/><Cell col=\"3\"/><Cell col=\"4\"/><Cell col=\"5\"/><Cell col=\"6\"/><Cell col=\"7\"/><Cell col=\"8\"/><Cell col=\"9\"/><Cell col=\"10\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static10","165","20","77","14",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("스프링부트로 ");
            obj.set_background("");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_DetailEssential");
            this.addChild(obj.name, obj);

            obj = new Button("getButton","269","16","62","35",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Button("Button00_00","341","16","62","35",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("추가");
            this.addChild(obj.name, obj);

            obj = new Button("Button00_01","413","16","62","35",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            obj = new Button("Button00_02","485","16","62","35",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("저장");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this.div_search.form
            obj = new Layout("default","",0,0,this.div_search.form,function(p){});
            this.div_search.form.addLayout(obj.name, obj);

            //-- Default Layout : this.div_detail.form
            obj = new Layout("default","",0,0,this.div_detail.form,function(p){});
            this.div_detail.form.addLayout(obj.name, obj);

            //-- Default Layout : this
            obj = new Layout("default","",1000,700,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item6","div_detail.form.edt_name","accessibilitydescription","ds_hand","FULL__NAME");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","div_detail.form.msk_id","accessibilityaction","ds_hand","EMPL_ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","div_detail.form.edt_name","value","ds_hand","FULL__NAME");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item9","div_detail.form.cbo_dept","acceptvaluetype","ds_hand","DEPT_NAME");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","div_detail.form.Static00","accessibilityaction","ds_hand","dept_ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item0","div_detail.form.msk_id","value","ds_hand","dept_ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","div_detail.form.cbo_dept","value","ds_hand","DEPT_NAME");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item5","div_detail.form.Calendar00","value","ds_hand","HIRE_DATE");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item7","div_detail.form.msk_salary","value","ds_hand","SALARY");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item8","div_detail.form.txt_memo","value","ds_hand","MEMO");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item10","div_detail.form.Calendar01","visible","ds_hand","MARRIED");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item12","div_detail.form.cbo_dept","text","ds_position","pos_name");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item11","div_detail.form.cbo_dept","accessibilityaction","ds_hand","DEPT_NAME");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item13","div_detail.form.lst_pos","value","ds_hand","POS_CODE");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item14","div_detail.form.Radio00","value","ds_hand","GENDER");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Hello.xfdl", function() {

        var hello = "안녕하세요!";

        /***********************************************************/
        /* 프 로 그 램 : C:\handsoft\Work\Hello.xfdl
        /* 작 성 일 자 : 22
        /* 작  성   자 : 조 재 표
        /* 설       명 :
        /***********************************************************/


        this.div_detail_edt_name_onchanged = function(obj,e)
        {

        };

        this.btn_retrieve_onclick = function(obj,e)
        {
        	var req = new nexacro.HttpRequest();
        	req.method
        	req.set_httpMethod("GET"); //?왜 안뜨지
        	req.set_url("http://localhost:8080/board/list");





        //	this.transaction(

        // 	"handRet", //서비스 id
        // 	"http://localhost:8080/board/list" ,// sURL(실제 서버 주소)
        // 	"", // inDataSet 보낼 데이터가 없으니 비우기
        // 	"ds_hand=out_ds", //outDataSet (out_ds -> ds_hand)
        // 	"",	// 파라미터
        // 	"fn_call");


        // 	"strSelect", //서비스 id
        // 	"SvcURL::select_emp.jsp?a=b&b=c", //호출할 url    ?a=b&b=c,
        // 	"", //저장 server ds= client ds
        // 	"ds_hand = out_emp", //조회 client ds = server ds
        // 	"a=b b=c c=" + nexacro.wrapQuote("d d"), //전달값
        // 	"fn_call"); //callback 함수 , 비동기는 언제 끝날지 모르니까

        };

        this.fn_loadUsers = function()
        {

        }


        this.fn_call = function(svcid, ecd, emsg)
        {
        	if(ecd >= 0)
        	{
        		if(svcid == "strSelect")
        		{
        			alert(this.ds_hand.getRowCount() + '건 조회');
        		}else if(svcid == "strSave")
        		{
        			alert("저장 성공");
        			}
        		}else{
        		 alert("error: " + ecd + ":" + emsg);
        	}
        }
        //내가 만든  ds와 넥사크로 회사에서 제공하는 ds가 불일치해서 결과값이 잘못나오는 것 같음


        this.btn_add_onclick = function(obj,e)
        {
        	this.ds_hand.addRow();   //레코드 추가
        	this.ds_hand.setColumn(this.ds_emp.rowposition,"HIRE_DATE","20200621");   //HIRE DATE 컬럼에 값을 넣어줌

        };

        this.btn_del_onclick = function(obj,e)
        {
        	this.ds_emp.deleteRow(this.ds_hand.rowposition);
        };

        this.btn_save_onclick = function(obj,e)
        {
        		this.transaction(
        		"strSave", //서비스 id
        		"SvcURL::select_emp.jsp?a=b&b=c" ,//호출할 url    ?a=b&b=c,
        		"in_hand = ds_hand:U", //저장 server ds= client ds
        		"", //조회 client ds = server ds
        		"a=b b=c c=" + nexacro.wrapQuote("d d"), //전달값
        		"fn_call"); //callback 함수 , 비동기는 언제 끝날지 모르니까
        };





        this.getButton_onclick = function(obj,e)
        {

        };

        this.Button00_onclick = function(obj,e)
        {
        	nexacro.Data
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_onload,this);
            this.addEventHandler("ontimer",this.Form_Emp_ontimer,this);
            this.div_search.form.btn_dept.addEventHandler("onclick",this.div_search_btn_dept_onclick,this);
            this.div_search.form.rdo_gender.addEventHandler("onitemchanged",this.div_search_rdo_gender_onitemchanged,this);
            this.div_search.form.btn_reset.addEventHandler("onclick",this.div_cont_btn_reset_onclick,this);
            this.btn_retrieve.addEventHandler("onclick",this.btn_retrieve_onclick,this);
            this.btn_add.addEventHandler("onclick",this.btn_add_onclick,this);
            this.btn_del.addEventHandler("onclick",this.btn_del_onclick,this);
            this.btn_save.addEventHandler("onclick",this.btn_save_onclick,this);
            this.div_detail.form.Static04.addEventHandler("onclick",this.Div00_Static04_onclick,this);
            this.div_detail.form.Static07.addEventHandler("onclick",this.Div00_Static07_onclick,this);
            this.div_detail.form.edt_name.addEventHandler("canchange",this.div_detail_edt_name_canchange,this);
            this.div_detail.form.edt_name.addEventHandler("onchanged",this.div_detail_edt_name_onchanged,this);
            this.div_detail.form.Static10.addEventHandler("onclick",this.div_detail_Static10_onclick,this);
            this.div_detail.form.Static05.addEventHandler("onclick",this.Div00_Static05_onclick,this);
            this.Static10.addEventHandler("onclick",this.div_detail_Static10_onclick,this);
            this.getButton.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button00_00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button00_01.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button00_02.addEventHandler("onclick",this.Button00_onclick,this);
            this.ds_emp.addEventHandler("cancolumnchange",this.ds_emp_cancolumnchange,this);
            this.ds_emp.addEventHandler("onrowsetchanged",this.ds_emp_onrowsetchanged,this);
            this.ds_emp.addEventHandler("onrowposchanged",this.ds_emp_onrowposchanged,this);
        };
        this.loadIncludeScript("Hello.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
