# Task A2.4: Dry-Run Analysis for withdraw(7500)

## Initial State
- `balance` = 10000.0
- `attempts` = 0
- `amount` = 7500.0

## Step-by-Step Execution Trace

| Step | Code Expression / Check | Evaluated Result | Variable States |
| :--- | :--- | :--- | :--- |
| **1** | Call `withdraw(7500.0)` | Invoked | `balance` = 10000.0, `attempts` = 0, `amount` = 7500.0 |
| **2** | Check `amount < 500` | `7500.0 < 500` $\rightarrow$ **FALSE** | Unchanged |
| **3** | Check `amount > 20000` | `7500.0 > 20000` $\rightarrow$ **FALSE** | Unchanged |
| **4** | Check `amount % 500 != 0` | `7500.0 % 500 == 0` $\rightarrow$ **FALSE** | Unchanged |
| **5** | Check `amount > balance` | `7500.0 > 10000.0` $\rightarrow$ **FALSE** | Unchanged |
| **6** | Execute `balance -= amount` | `10000.0 - 7500.0` | `balance` = **2500.0**, `attempts` = 0, `amount` = 7500.0 |
| **7** | Print Success & New Balance | Output printed | `balance` = **2500.0** |

## Final Outcome
- Transaction succeeds without throwing exceptions.
- `attempts` remain **0**.
- Final `balance` = **2500.0**.