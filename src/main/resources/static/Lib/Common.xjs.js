//XJS=Common.xjs
(function()
{
    return function(path)
    {
        var obj;
    
        // User Script
        this.registerScript(path, function() {

        /*******************************************************************************
         * Grid Sort
         * parameter : object Grid / GridClickEventInfo e
         * return None
         ******************************************************************************/
        this.CONST_NONE_MARK = "";
        this.CONST_ASC_MARK = "↑";
        this.CONST_DESC_MARK = "↓";
        this.CONST_SORT_FLAG = false;
        this.cfn_GridSort = function (obj, e)
        {
        	var bindDs = eval(this.lookup(obj.binddataset));
        	var a;
        	var b;

        	if (bindDs.rowcount == 0)
        	{
        		return false;
        	}

        	var CONST_SORT_MARK = "";
        	var BodyColId = (obj.getCellProperty("body", e.col, "text")).toString().split(":");
        	for (var i = 0; i < obj.getCellCount("head"); i++)
        	{
        		if (obj.getCellText(-1, i) == "undefined")
        		{
        			continue;
        		}

        		var strHeadText = obj.getCellText(-1, i);

        		if (i == e.cell)
        		{


        			if (strHeadText.substr(strHeadText.length - 1) == this.CONST_ASC_MARK)
        			{

        				obj.setCellProperty("head", i, "text", strHeadText.substr(0, strHeadText.length - 1) + this.CONST_DESC_MARK);
        				bindDs.set_keystring("S:-" + BodyColId[1]);

        			}
        			else if (strHeadText.substr(strHeadText.length - 1) == this.CONST_DESC_MARK)
        			{

        				obj.setCellProperty("head", i, "text", strHeadText.substr(0, strHeadText.length - 1) + this.CONST_ASC_MARK);
        				bindDs.set_keystring("S:+" + BodyColId[1]);
        			}
        			else
        			{

        				obj.setCellProperty("head", i, "text", strHeadText + this.CONST_ASC_MARK);
        				bindDs.set_keystring("S:+" + BodyColId[1]);
        			}
        		}
        		else
        		{
        			if (strHeadText.substr(strHeadText.length - 1) == this.CONST_ASC_MARK || strHeadText.substr(strHeadText.length - 1) == this.CONST_DESC_MARK)
        			{
        				obj.setCellProperty("head", i, "text", strHeadText.substr(0, strHeadText.length - 1));
        			}
        		}
        	}
        }

        });
    
        this.loadIncludeScript(path);
        
        obj = null;
    };
}
)();
