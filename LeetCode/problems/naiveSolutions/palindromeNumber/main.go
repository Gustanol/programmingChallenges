package main
import ("fmt")

// function to determinate if given number is a palindrome
func isPalindrome(number string) string {
  // variable that will keep the inverted number. For now, it is empty
  var invertedNumber string
  // loop to iterate for each inverse string "number" index
  for i := len(number); i > 0; i-- {
    // modifies "invertedNumber" variable adding the current "number" index "i" char
    invertedNumber += string(number[i - 1]) // obs: taking a char directly by its index, returns a byte slice. Therefore, we use `string()` function
  }
  // conditions that will verify if the number is a palindrome
  if invertedNumber == number {
    return "The number is a palindrome!"
  }
  return "The number is not a palindrome!"
}

func main() {
  var number string
  
  // it will read the user number
  fmt.Print("Enter a number: ")
  fmt.Scan(&number)
  
  fmt.Println("\n" + isPalindrome(number))
}