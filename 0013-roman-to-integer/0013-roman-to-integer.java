class Solution {
    public int romanToInt(String s) {
        int Icount=0;
        int Vcount=0;
        int Xcount=0;
        int Lcount=0;
        int Ccount=0;
        int Dcount=0;
        int Mcount=0;
        int IVcount=0;
        int IXcount=0;
        int XLcount=0;
        int XCcount=0;
        int CDcount=0;
        int MDcount=0;

        for(int i=0;i< s.length();i++){
            if(s.charAt(i)=='I'){
                Icount+=1;
            }
            else if(s.charAt(i)=='V'){
                if(i > 0 && s.charAt(i-1)=='I'){
                    Icount-=1;
                    IVcount+=4;
                }
                else
                Vcount+=5;
            }
             else if(s.charAt(i)=='X'){
                if(i > 0 && s.charAt(i-1)=='I'){
                    Icount-=1;
                    IXcount+=9;
                }
                else
                Xcount+=10;
            }
             else if(s.charAt(i)=='L'){
                 if(i > 0 && s.charAt(i-1)=='X'){
                    Xcount-=10;
                    XLcount+=40;
                }
                else
                Lcount+=50;
            }
             else if(s.charAt(i)=='C'){
                 if(i > 0 && s.charAt(i-1)=='X'){
                    Xcount-=10;
                    XCcount+=90;
                }
                else
                Ccount+=100;
            }
             else if(s.charAt(i)=='D'){
                 if(i > 0 && s.charAt(i-1)=='C'){
                    Ccount-=100;
                    CDcount+=400;
                }
                else
                Dcount+=500;
            } else {
                if(i > 0 && s.charAt(i-1)=='C'){
                    Ccount-=100;
                    MDcount+=900;
                }
                else
                
                Mcount+=1000;
            }
        }
        return Icount+Vcount+Xcount+Lcount+Ccount+Dcount+Mcount+IVcount+IXcount+XLcount+XCcount+CDcount+MDcount;
    }
}