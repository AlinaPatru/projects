using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DameJoc.Models
{
    class LoadGame
    {
        public static List<List<Piesa>> Init()
        {
            List<List<Piesa>> list = new List<List<Piesa>>();

            for (int i = 0; i < 8; i++)
            {
                list.Add(new List<Piesa>());
                for (int j = 0; j < 8; j++)
                {
                    if (i % 2 == j % 2)
                        list[i].Add(new Piesa() { PiesaImg = null, X = i, Y = j, Background = @"/Images/back7.png", Player = null, Tip = null });
                    else
                    {
                        list[i].Add(new Piesa() { PiesaImg = null, X = i, Y = j, Background = @"/Images/back8.png", Player = null, Tip = "piesa" });
                    }
                }
            }
            return list;
        }
    }
}
