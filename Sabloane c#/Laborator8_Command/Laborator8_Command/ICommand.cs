using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Command
{
    public interface ICommand
    {
        char ArithmOperator { get; set; }
        double Operand { get; set; }

        void Execute();
    }
}
