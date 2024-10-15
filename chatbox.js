// Predefined question-answer pairs
const questionAnswerPairs = {
  "What is your name?": "My name is Chatbot.",
  "How can I help you?": "I can assist you with your queries.",
  "What is the weather today?": "The weather is sunny.",
};

// Function to find the closest matching question
function getAnswer(userQuestion) {
  let closestMatch = null;
  let highestMatchCount = 0;

  // Split user's input into words
  const userWords = userQuestion.toLowerCase().split(/\s+/);

  // Loop through each predefined question
  for (const question in questionAnswerPairs) {
    const questionWords = question.toLowerCase().split(/\s+/);
    let matchCount = 0;

    // Count how many words match
    userWords.forEach((userWord) => {
      if (questionWords.includes(userWord)) {
        matchCount++;
      }
    });

    // Update the closest match if we find a better match
    if (matchCount > highestMatchCount) {
      highestMatchCount = matchCount;
      closestMatch = question;
    }
  }

  // Return the corresponding answer or a default message if no match
  return closestMatch
    ? questionAnswerPairs[closestMatch]
    : "Sorry, I don't understand your question.";
}

// Example usage
const userQuestion = "What's the weather like today?";
const answer = getAnswer(userQuestion);

console.log(answer);
