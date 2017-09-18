using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DameJoc.Models
{

    class Moves
    {

        public Piesa MovesPlayer1(Piesa Previous, Piesa Curent, List<List<Piesa>> list)
        {

            if (Math.Abs(Curent.Y - Previous.Y) > 2 || Curent.Y == Previous.Y || Math.Abs(Curent.X - Previous.X) > 2)
                if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null || list[Curent.X][Curent.Y].Player == null)
                {
                    return Previous;
                }
            if (Curent.X > Previous.X && Curent.PiesaImg == null)
            {
                if (Curent.X - Previous.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player2"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;

                            if (Curent.X == 7)
                            {
                                list[Curent.X][Curent.Y].PiesaImg = @"/Images/piece21.png";
                                list[Curent.X][Curent.Y].Tip = "rege";
                            }

                            if (Curent.X < 6 && Curent.Y == 7)
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X < 6 && Curent.Y == 0)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }

                            if (Curent.X < 6 && Curent.Y == 1)
                            {
                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X < 6 && Curent.Y == 6)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }

                            if ((Curent.X < 6 && Curent.Y > 1) && (Curent.X < 5 && Curent.Y < 6))
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                        //MovesPlayer2(Curent, list[Curent.X - 2][Curent.Y - 2], list);
                                    }
                                }

                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }

                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }
                    }
                    else
                    {
                        list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                        list[Curent.X][Curent.Y].Player = Previous.Player;
                        list[Curent.X][Curent.Y].Tip = Previous.Tip;

                        list[Previous.X][Previous.Y].PiesaImg = null;
                        list[Previous.X][Previous.Y].Player = null;
                        list[Previous.X][Previous.Y].Tip = null;

                        if (Curent.X == 7)
                        {
                            list[Curent.X][Curent.Y].PiesaImg = @"/Images/piece21.png";
                            list[Curent.X][Curent.Y].Tip = "rege";
                        }
                        return null;
                    }
                }
            }
            else
            {
                return Previous;
            }


            return null;
        }


        public Piesa MovesPlayer2(Piesa Previous, Piesa Curent, List<List<Piesa>> list)
        {

            if (Math.Abs(Curent.Y - Previous.Y) > 2 || Curent.Y == Previous.Y || Math.Abs(Curent.X - Previous.X) > 2)
                if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null || list[Curent.X][Curent.Y].Player == null)
                {
                    return Previous;
                }

            if (Curent.X < Previous.X && Curent.PiesaImg == null)
            {
                if (Previous.X - Curent.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player1"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;

                            if (Curent.X == 0)
                            {
                                list[Curent.X][Curent.Y].PiesaImg = @"/Images/piece22.png";
                                list[Curent.X][Curent.Y].Tip = "rege";
                            }

                            if (Curent.X > 1 && Curent.Y == 7)
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X > 1 && Curent.Y == 0)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }

                            if (Curent.X > 1 && Curent.Y == 1)
                            {
                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X > 1 && Curent.Y == 6)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }


                            if ((Curent.X > 1 && Curent.Y > 1) && (Curent.X > 1 && Curent.Y < 6))
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }

                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }

                    list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                    list[Curent.X][Curent.Y].Player = Previous.Player;
                    list[Curent.X][Curent.Y].Tip = Previous.Tip;

                    list[Previous.X][Previous.Y].PiesaImg = null;
                    list[Previous.X][Previous.Y].Player = null;
                    list[Previous.X][Previous.Y].Tip = null;

                    if (Curent.X == 0)
                    {
                        list[Curent.X][Curent.Y].PiesaImg = @"/Images/piece22.png";
                        list[Curent.X][Curent.Y].Tip = "rege";
                    }
                }
            }
            else
            {
                return Previous;
            }

            return null;
        }


        public Piesa King1(Piesa Previous, Piesa Curent, List<List<Piesa>> list)
        {
            if (Math.Abs(Curent.Y - Previous.Y) > 2 || Curent.Y == Previous.Y || Math.Abs(Curent.X - Previous.X) > 2)
                if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null || list[Curent.X][Curent.Y].Player == null)
                {
                    return Previous;
                }

            if (Curent.X > Previous.X && Curent.PiesaImg == null)
            {
                if (Curent.X - Previous.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player2"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;

                            if (Curent.X < 6 && Curent.Y == 7)
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X < 6 && Curent.Y == 0)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }

                            if (Curent.X < 6 && Curent.Y == 1)
                            {
                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X < 6 && Curent.Y == 6)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }

                            if ((Curent.X < 6 && Curent.Y > 1) && (Curent.X < 5 && Curent.Y < 6))
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }

                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }

                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }

                    list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                    list[Curent.X][Curent.Y].Player = Previous.Player;
                    list[Curent.X][Curent.Y].Tip = Previous.Tip;

                    list[Previous.X][Previous.Y].PiesaImg = null;
                    list[Previous.X][Previous.Y].Player = null;
                    list[Previous.X][Previous.Y].Tip = null;


                    return null;
                }
            }

            if (Curent.X < Previous.X && Curent.PiesaImg == null)
            {
                if (Previous.X - Curent.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player2"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;

                            if (Curent.X > 1 && Curent.Y == 7)
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X > 1 && Curent.Y == 0)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }

                            if (Curent.X > 1 && Curent.Y == 1)
                            {
                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X > 1 && Curent.Y == 6)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }


                            if ((Curent.X > 1 && Curent.Y > 1) && (Curent.X > 1 && Curent.Y < 6))
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }

                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player2") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }

                    list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                    list[Curent.X][Curent.Y].Player = Previous.Player;
                    list[Curent.X][Curent.Y].Tip = Previous.Tip;

                    list[Previous.X][Previous.Y].PiesaImg = null;
                    list[Previous.X][Previous.Y].Player = null;
                    list[Previous.X][Previous.Y].Tip = null;

                }
            }

            return null;
        }

        public Piesa King2(Piesa Previous, Piesa Curent, List<List<Piesa>> list)
        {
            if (Math.Abs(Curent.Y - Previous.Y) > 2 || Curent.Y == Previous.Y || Math.Abs(Curent.X - Previous.X) > 2)
                if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null || list[Curent.X][Curent.Y].Player == null)
                {
                    return Previous;
                }

            if (Curent.X > Previous.X && Curent.PiesaImg == null)
            {
                if (Curent.X - Previous.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player1"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;


                            if (Curent.X < 6 && Curent.Y == 7)
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X < 6 && Curent.Y == 0)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }

                            if (Curent.X < 6 && Curent.Y == 1)
                            {
                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X < 6 && Curent.Y == 6)
                                {
                                    if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }

                            if ((Curent.X < 6 && Curent.Y > 1) && (Curent.X < 5 && Curent.Y < 6))
                            {
                                if (list[Curent.X + 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X + 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }

                                if (list[Curent.X + 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X + 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X + 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }

                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }

                    list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                    list[Curent.X][Curent.Y].Player = Previous.Player;
                    list[Curent.X][Curent.Y].Tip = Previous.Tip;

                    list[Previous.X][Previous.Y].PiesaImg = null;
                    list[Previous.X][Previous.Y].Player = null;
                    list[Previous.X][Previous.Y].Tip = null;


                    return null;
                }
            }

            if (Curent.X < Previous.X && Curent.PiesaImg == null)
            {
                if (Previous.X - Curent.X == 2 && Math.Abs(Previous.Y - Curent.Y) == 2)
                {
                    if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player != null)
                    {
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player.Equals("Player1"))
                        {
                            list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                            list[Curent.X][Curent.Y].Player = Previous.Player;
                            list[Curent.X][Curent.Y].Tip = Previous.Tip;

                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].PiesaImg = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player = null;
                            list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Tip = null;

                            list[Previous.X][Previous.Y].PiesaImg = null;
                            list[Previous.X][Previous.Y].Player = null;
                            list[Previous.X][Previous.Y].Tip = null;

                            if (Curent.X > 1 && Curent.Y == 7)
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    { return Curent; }
                                }
                            }
                            else
                                if (Curent.X > 1 && Curent.Y == 0)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                        { return Curent; }
                                    }
                                }


                            if (Curent.X > 1 && Curent.Y == 1)
                            {
                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                            else
                            {
                                if (Curent.X > 1 && Curent.Y == 6)
                                {
                                    if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                    {
                                        if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                        { return Curent; }
                                    }
                                }
                            }


                            if ((Curent.X > 1 && Curent.Y > 1) && (Curent.X > 1 && Curent.Y < 6))
                            {
                                if (list[Curent.X - 1][Curent.Y - 1].Player != null)
                                {

                                    if (list[Curent.X - 1][Curent.Y - 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y - 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }

                                if (list[Curent.X - 1][Curent.Y + 1].Player != null)
                                {
                                    if (list[Curent.X - 1][Curent.Y + 1].Player.Equals("Player1") && list[Curent.X - 2][Curent.Y + 2].Player == null)
                                    {
                                        return Curent;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        return Previous;
                    }
                }
                else
                {
                    if (Math.Abs(Curent.Y - Previous.Y) == 1 && Math.Abs(Curent.X - Previous.X) > 1)
                        if (list[((Curent.X + Previous.X) / 2)][((Curent.Y + Previous.Y) / 2)].Player == null)
                        {
                            return Previous;
                        }

                    list[Curent.X][Curent.Y].PiesaImg = Previous.PiesaImg;
                    list[Curent.X][Curent.Y].Player = Previous.Player;
                    list[Curent.X][Curent.Y].Tip = Previous.Tip;

                    list[Previous.X][Previous.Y].PiesaImg = null;
                    list[Previous.X][Previous.Y].Player = null;
                    list[Previous.X][Previous.Y].Tip = null;

                }
            }

            return null;
        }

        public Boolean End(List<List<Piesa>> list, string player)
        {
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                {
                    if (list[i][j].Player != null)
                        if (list[i][j].Player.Equals(player))
                            return false;
                }
            return true;
        }


    }
}
