using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DameJoc.Models
{
    static class Utils
    {
        public static List<List<Piesa>> Init ()
        {
            List<List<Piesa>> list = new List<List<Piesa>>();

            for (int i = 0; i < 8; i++)
            {
                list.Add(new List<Piesa>());
                for (int j = 0; j < 8; j++)
                {
                    if (i % 2 == j % 2)//@"/Images/piesa2.png"
                        list[i].Add(new Piesa() { PiesaImg = null, X = i, Y = j, Background = @"/Images/back7.png", Player = null, Tip = null });
                    else
                    {
                        if (i < 3)
                            list[i].Add(new Piesa() { PiesaImg = @"/Images/piesa1.png", X = i, Y = j, Background = @"/Images/back8.png", Player = "Player1", Tip = "piesa" });
                        else if (i >= 5)
                            list[i].Add(new Piesa() { PiesaImg = @"/Images/piesa2.png", X = i, Y = j, Background = @"/Images/back8.png", Player = "Player2", Tip = "piesa" });
                        else
                            list[i].Add(new Piesa() { PiesaImg = null, X = i, Y = j, Background = @"/Images/back8.png", Player = null, Tip = null });
                    }
                }
            }
            return list;
        }
    }
}
