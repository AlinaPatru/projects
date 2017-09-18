using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Command
{
    public class CalculatorInvoker
    {
        private ICommand _iCommand;

        public CalculatorInvoker()
        {
            _iCommand = new CalculatorCommand();
        }

        public void Compute(char arithmOperator,double operand)
        {
            _iCommand.ArithmOperator = arithmOperator;
            _iCommand.Operand = operand;
            _iCommand.Execute();
        }
    }
}
