package kColourLED;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;

class ColourPicker extends HorizontalFieldManager
{
    LabelField ColorLabel;
    ObjectChoiceField ColorOCF;
    LabelField ColorView;
    int labelColor = Color.BLACK;
    int setColor = Color.WHITE;
    String ColorArray[] = { "ALICEBLUE",
                            "ANTIQUEWHITE",
                            "AQUA",
                            "AQUAMARINE",
                            "AZURE",
                            "BEIGE",
                            "BISQUE",
                            "BLACK",
                            "BLANCHEDALMOND",
                            "BLUE",
                            "BLUEVIOLET",
                            "BROWN",
                            "BURLYWOOD",
                            "CADETBLUE",
                            "CHARTREUSE",
                            "CHOCOLATE",
                            "CORAL",
                            "CORNFLOWERBLUE",
                            "CORNSILK",
                            "CRIMSON",
                            "CYAN",
                            "DARKBLUE",
                            "DARKCYAN",
                            "DARKGOLDENROD",
                            "DARKGRAY",
                            "DARKGREEN",
                            "DARKKHAKI",
                            "DARKMAGENTA",
                            "DARKOLIVEGREEN",
                            "DARKORANGE",
                            "DARKORCHID",
                            "DARKRED",
                            "DARKSALMON",
                            "DARKSEAGREEN",
                            "DARKSLATEBLUE",
                            "DARKSLATEGRAY",
                            "DARKTURQUOISE",
                            "DARKVIOLET",
                            "DEEPPINK",
                            "DEEPSKYBLUE",
                            "DIMGRAY",
                            "DODGERBLUE",
                            "FIREBRICK",
                            "FLORALWHITE",
                            "FORESTGREEN",
                            "FUCHSIA",
                            "GAINSBORO",
                            "GHOSTWHITE",
                            "GOLD",
                            "GOLDENROD",
                            "GRAY",
                            "GREEN",
                            "GREENYELLOW",
                            "HONEYDEW",
                            "HOTPINK",
                            "INDIANRED",
                            "INDIGO",
                            "IVORY",
                            "KHAKI",
                            "LAVENDER",
                            "LAVENDERBLUSH",
                            "LAWNGREEN",
                            "LEMONCHIFFON",
                            "LIGHTBLUE",
                            "LIGHTCORAL",
                            "LIGHTCYAN",
                            "LIGHTGOLDENRODYELLOW",
                            "LIGHTGREEN",
                            "LIGHTGREY",
                            "LIGHTPINK",
                            "LIGHTSALMON",
                            "LIGHTSEAGREEN",
                            "LIGHTSKYBLUE",
                            "LIGHTSLATEGRAY",
                            "LIGHTSTEELBLUE",
                            "LIGHTYELLOW",
                            "LIME",
                            "LIMEGREEN",
                            "LINEN",
                            "MAGENTA",
                            "MAROON",
                            "MEDIUMAQUAMARINE",
                            "MEDIUMBLUE",
                            "MEDIUMORCHID",
                            "MEDIUMPURPLE",
                            "MEDIUMSEAGREEN",
                            "MEDIUMSLATEBLUE",
                            "MEDIUMSPRINGGREEN",
                            "MEDIUMTURQUOISE",
                            "MEDIUMVIOLETRED",
                            "MIDNIGHTBLUE",
                            "MINTCREAM",
                            "MISTYROSE",
                            "MOCCASIN",
                            "NAVAJOWHITE",
                            "NAVY",
                            "OLDLACE",
                            "OLIVE",
                            "OLIVEDRAB",
                            "ORANGE",
                            "ORANGERED",
                            "ORCHID",
                            "PALEGOLDENROD",
                            "PALEGREEN",
                            "PALETURQUOISE",
                            "PALEVIOLETRED",
                            "PAPAYAWHIP",
                            "PEACHPUFF",
                            "PERU",
                            "PINK",
                            "PLUM",
                            "POWDERBLUE",
                            "PURPLE",
                            "RED",
                            "ROSYBROWN",
                            "ROYALBLUE",
                            "SADDLEBROWN",
                            "SALMON",
                            "SANDYBROWN",
                            "SEAGREEN",
                            "SEASHELL",
                            "SIENNA",
                            "SILVER",
                            "SKYBLUE",
                            "SLATEBLUE",
                            "SLATEGRAY",
                            "SNOW",
                            "SPRINGGREEN",
                            "STEELBLUE",
                            "TAN",
                            "TEAL",
                            "THISTLE",
                            "TOMATO",
                            "TURQUOISE",
                            "VIOLET",
                            "WHEAT",
                            "WHITE",
                            "WHITESMOKE",
                            "YELLOW",
                            "YELLOWGREEN"
                        };
    ColourPicker(String title)
    {
        //ColorLabel = new LabelField(title,80,20,DrawStyle.LEFT);
        /*{
            protected void paint(Graphics graphics)
            {
                graphics.setColor(labelColor);
                super.paint(graphics);
            }
        };*/
        ColorOCF = new ObjectChoiceField("",ColorArray, 0,Field.FIELD_LEFT)
        {
            protected void fieldChangeNotify(int context)
            { 
                int indexColor = getSelectedIndex();
                switch (indexColor) 
                {
                    case 0:  labelColor = Color.ALICEBLUE;
                             break;
                    case 1:  labelColor = Color.ANTIQUEWHITE;
                             break;
                    case 2:  labelColor = Color.AQUA;
                             break;
                    case 3:  labelColor = Color.AQUAMARINE;
                             break;
                    case 4:  labelColor = Color.AZURE;
                             break;
                    case 5:  labelColor = Color.BEIGE;
                             break;
                    case 6:  labelColor = Color.BISQUE;
                             break;
                    case 7:  labelColor = Color.BLACK;
                             break;
                    case 8:  labelColor = Color.BLANCHEDALMOND;
                             break;
                    case 9:  labelColor = Color.BLUE;
                             break;
                    case 10:  labelColor = Color.BLUEVIOLET;
                             break;
                    case 11:  labelColor = Color.BROWN;
                             break;
                    case 12:  labelColor = Color.BURLYWOOD;
                             break;
                    case 13:  labelColor = Color.CADETBLUE;
                             break;
                    case 14:  labelColor = Color.CHARTREUSE;
                             break;
                    case 15:  labelColor = Color.CHOCOLATE;
                             break;
                    case 16:  labelColor = Color.CORAL;
                             break;
                    case 17:  labelColor = Color.CORNFLOWERBLUE;
                             break;
                    case 18:  labelColor = Color.CORNSILK;
                             break;
                    case 19:  labelColor = Color.CRIMSON;
                             break;
                    case 20:  labelColor = Color.CYAN;
                             break;
                    case 21:  labelColor = Color.DARKBLUE;
                             break;
                    case 22:  labelColor = Color.DARKCYAN;
                             break;
                    case 23:  labelColor = Color.DARKGOLDENROD;
                             break;
                    case 24:  labelColor = Color.DARKGRAY;
                             break;
                    case 25:  labelColor = Color.DARKGREEN;
                             break;
                    case 26:  labelColor = Color.DARKKHAKI;
                             break;
                    case 27:  labelColor = Color.DARKMAGENTA;
                             break;
                    case 28:  labelColor = Color.DARKOLIVEGREEN;
                             break;
                    case 29:  labelColor = Color.DARKORANGE;
                             break;
                    case 30:  labelColor = Color.DARKORCHID;
                             break;
                    case 31:  labelColor = Color.DARKRED;
                             break;
                    case 32:  labelColor = Color.DARKSALMON; 
                              break;
                    case 33:  labelColor = Color.DARKSEAGREEN; 
                                break;
                    case 34:  labelColor = Color.DARKSLATEBLUE; 
                                break;
                    case 35:  labelColor = Color.DARKSLATEGRAY;
                                break;
                    case 36:  labelColor = Color.DARKTURQUOISE; 
                                break;
                    case 37:  labelColor = Color.DARKVIOLET; 
                                break;
                    case 38:  labelColor = Color.DEEPPINK; 
                                break;
                    case 39:  labelColor = Color.DEEPSKYBLUE; 
                                break;
                    case 40:  labelColor = Color.DIMGRAY; 
                                break;
                    case 41:  labelColor = Color.DODGERBLUE;
                                break;
                    case 42:  labelColor = Color.FIREBRICK; 
                                break;
                    case 43:  labelColor = Color.FLORALWHITE; 
                                break;
                    case 44:  labelColor = Color.FORESTGREEN; 
                                break;
                    case 45:  labelColor = Color.FUCHSIA; 
                                break;
                    case 46:  labelColor = Color.GAINSBORO; 
                                break;
                    case 47:  labelColor = Color.GHOSTWHITE;
                                break;
                    case 48:  labelColor = Color.GOLD; 
                                break;
                    case 49:  labelColor = Color.GOLDENROD; 
                                break;
                    case 50:  labelColor = Color.GRAY; 
                                break;
                    case 51:  labelColor = Color.GREEN; 
                                break;
                    case 52:  labelColor = Color.GREENYELLOW; 
                                break;
                    case 53:  labelColor = Color.HONEYDEW; 
                                break;
                    case 54:  labelColor = Color.HOTPINK;
                                break;
                    case 55:  labelColor = Color.INDIANRED; 
                                break;
                    case 56:  labelColor = Color.INDIGO; 
                                break;
                    case 57:  labelColor = Color.IVORY; 
                                break;
                    case 58:  labelColor = Color.KHAKI; 
                                break;
                    case 59:  labelColor = Color.LAVENDER; 
                                break;
                    case 60:  labelColor = Color.LAVENDERBLUSH; 
                                break;
                    case 61:  labelColor = Color.LAWNGREEN;
                                break;
                    case 62:  labelColor = Color.LEMONCHIFFON; 
                                break;
                    case 63:  labelColor = Color.LIGHTBLUE; 
                                break;
                    case 64:  labelColor = Color.LIGHTCORAL; 
                                break;
                    case 65:  labelColor = Color.LIGHTCYAN; 
                                break;
                    case 66:  labelColor = Color.LIGHTGOLDENRODYELLOW; 
                                break;
                    case 67:  labelColor = Color.LIGHTGREEN;
                                break;
                    case 68:  labelColor = Color.LIGHTGREY; 
                                break;
                    case 69:  labelColor = Color.LIGHTPINK; 
                                break;
                    case 70:  labelColor = Color.LIGHTSALMON; 
                                break;
                    case 71:  labelColor = Color.LIGHTSEAGREEN; 
                                break;
                    case 72:  labelColor = Color.LIGHTSKYBLUE; 
                                break;
                    case 73:  labelColor = Color.LIGHTSLATEGRAY;
                                break;
                    case 74:  labelColor = Color.LIGHTSTEELBLUE; 
                                break;
                    case 75:  labelColor = Color.LIGHTYELLOW; 
                                break;
                    case 76:  labelColor = Color.LIME; 
                                break;
                    case 77:  labelColor = Color.LIMEGREEN;
                                break;
                    case 78:  labelColor = Color.LINEN; 
                                break;
                    case 79:  labelColor = Color.MAGENTA; 
                                break;
                    case 80:  labelColor = Color.MAROON;
                                break;
                    case 81:  labelColor = Color.MEDIUMAQUAMARINE; 
                                break;
                    case 82:  labelColor = Color.MEDIUMBLUE;
                                break;
                    case 83:  labelColor = Color.MEDIUMORCHID; 
                                break;
                    case 84:  labelColor = Color.MEDIUMPURPLE;
                                break;
                    case 85:  labelColor = Color.MEDIUMSEAGREEN; 
                                break;
                    case 86:  labelColor = Color.MEDIUMSLATEBLUE;
                                break;
                    case 87:  labelColor = Color.MEDIUMSPRINGGREEN; 
                                break;
                    case 88:  labelColor = Color.MEDIUMTURQUOISE; 
                                break;
                    case 89:  labelColor = Color.MEDIUMVIOLETRED; 
                                break;
                    case 90:  labelColor = Color.MIDNIGHTBLUE; 
                                break;
                    case 91:  labelColor = Color.MINTCREAM;
                                break;
                    case 92:  labelColor = Color.MISTYROSE; 
                                break;
                    case 93:  labelColor = Color.MOCCASIN; 
                                break;
                    case 94:  labelColor = Color.NAVAJOWHITE; 
                                break;
                    case 95:  labelColor = Color.NAVY; 
                                break;
                    case 96:  labelColor = Color.OLDLACE; 
                                break;
                    case 97:  labelColor = Color.OLIVE; 
                                break;
                    case 98:  labelColor = Color.OLIVEDRAB;
                                break;
                    case 99:  labelColor = Color.ORANGE; 
                                break;
                    case 100:  labelColor = Color.ORANGERED; 
                                break;
                    case 101:  labelColor = Color.ORCHID; 
                                break;
                    case 102:  labelColor = Color.PALEGOLDENROD; 
                                break;
                    case 103:  labelColor = Color.PALEGREEN; 
                                break;
                    case 104:  labelColor = Color.PALETURQUOISE;
                                break;
                    case 105:  labelColor = Color.PALEVIOLETRED; 
                                break;
                    case 106:  labelColor = Color.PAPAYAWHIP; 
                                break;
                    case 107:  labelColor = Color.PEACHPUFF; 
                                break;
                    case 108:  labelColor = Color.PERU; 
                                break;
                    case 109:  labelColor = Color.PINK; 
                                break;
                    case 110:  labelColor = Color.PLUM; 
                                break;
                    case 111:  labelColor = Color.POWDERBLUE;
                                break;
                    case 112:  labelColor = Color.PURPLE; 
                                break;
                    case 113:  labelColor = Color.RED; 
                                break;
                    case 114:  labelColor = Color.ROSYBROWN; 
                                break;
                    case 115:  labelColor = Color.ROYALBLUE; 
                                break;
                    case 116:  labelColor = Color.SADDLEBROWN;
                                break;
                    case 117:  labelColor = Color.SALMON;
                                break; 
                    case 118:  labelColor = Color.SANDYBROWN;
                                break;
                    case 119:  labelColor = Color.SEAGREEN; 
                                break;
                    case 120:  labelColor = Color.SEASHELL; 
                                break;
                    case 121:  labelColor = Color.SIENNA; 
                                break;
                    case 122:  labelColor = Color.SILVER; 
                                break;
                    case 123:  labelColor = Color.SKYBLUE;
                                break;
                    case 124:  labelColor = Color.SLATEBLUE; 
                                break;
                    case 125:  labelColor = Color.SLATEGRAY;
                                break;
                    case 126:  labelColor = Color.SNOW; 
                                break;
                    case 127:  labelColor = Color.SPRINGGREEN; 
                                break;
                    case 128:  labelColor = Color.STEELBLUE; 
                                break;
                    case 129:  labelColor = Color.TAN; 
                                break;
                    case 130:  labelColor = Color.TEAL; 
                                break;
                    case 131:  labelColor = Color.THISTLE; 
                                break;
                    case 132:  labelColor = Color.TOMATO; 
                                break;
                    case 133:  labelColor = Color.TURQUOISE;
                                break;
                    case 134:  labelColor = Color.VIOLET; 
                                break;
                    case 135:  labelColor = Color.WHEAT; 
                                break;
                    case 136:  labelColor = Color.WHITE; 
                                break;
                    case 137:  labelColor = Color.WHITESMOKE; 
                                break;
                    case 138:  labelColor = Color.YELLOW; 
                                break;
                    case 139:  labelColor = Color.YELLOWGREEN;
                                break;
                }
                this.invalidate();
            }
        };
        
        ColorView = new LabelField("III COLOR III",DrawStyle.RIGHT|DrawStyle.VCENTER)
        {
            protected void paint(Graphics graphics)
            {
                graphics.setColor(labelColor);
                super.paint(graphics);
            }
        };
        //add(ColorLabel);
        add(ColorOCF);
        add(ColorView);
    }
    
    public int getColorValue()
    {
        return labelColor;
    }
}