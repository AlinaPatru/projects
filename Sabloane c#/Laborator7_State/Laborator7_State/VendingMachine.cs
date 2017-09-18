using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class VendingMachine
    {
        private int capacity;
        private State machineState;

        public VendingMachine()
        {
            capacity = 0;
            machineState = new NoCoinState(this);
        }

        public void UpdateState(EUserOption option)
        {
            switch(option)
            {
                case EUserOption.InsertCoin:
                    InsertCoin();
                    break;
                case EUserOption.EjectCoin:
                    EjectCoin();
                    break;
                case EUserOption.BuyProduct:
                    BuyProduct();
                    break;
                case EUserOption.FillMachine:
                    ReFill();
                    break;
                case EUserOption.InspectMachine:
                    Inspect();
                    break;
                case EUserOption.Exit:
                    break;
                default:
                    break;
            }
        }


        private void ReFill()
        {
            if (machineState is HasCoinState)
                Console.WriteLine("You can't refill now. Try again after the coin is ejected or the product bought.");
            else
            {
                int value = 0;
                while (value < 1)
                {
                    Console.WriteLine("Please enter the value for refill. The value must be greater than 0. ");
                    String readValue = Console.ReadLine();
                    value = Int32.Parse(readValue);
                }
                capacity += value;
                Console.WriteLine("The machine was refilled with " + value + " products");
                machineState = new SoldState(this);
            }
        }

        private bool BuyProduct()
        {

            if(IsEmpty())
            {
                SetMachineState(new SoldOutState(this));
            }
            if (machineState.BuyProduct())
            {
                capacity--;
                return true;
            }
            
            return false;
        }

        private void Inspect()
        {
            if (capacity > 0)
                Console.WriteLine("There are  =  " + capacity + "  products");
            else
                Console.WriteLine("There are no products.");
        }

        public bool IsEmpty()
        {
            if (capacity == 0)
            {
                return true;
            }
            return false;
        }

        public void SetMachineState(State state)
        {
            this.machineState = state;
        }
        

        private bool InsertCoin()
        {
            if (capacity < 1)
            {
                SetMachineState(new SoldOutState(this));
            }
            return machineState.InsertCoin();
        }


        public bool EjectCoin()
        {
            return machineState.EjectCoin();
        }

    }
}
