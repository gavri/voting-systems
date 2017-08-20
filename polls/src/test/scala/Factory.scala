package com.example.gavri.polls

trait Factory {
  def ballotSheetFromCandidateNames(candidates: String*) = {
    BallotSheet(candidates.toList.map(c => Candidate(c)))
  }

  def ballots = {
    val i = "instant run off winner"
    val c = "coombs winner"
    val (x, y) = ("other", "yet another")
    List(
      ballotSheetFromCandidateNames(x, c, y, i),
      ballotSheetFromCandidateNames(x, c, y, i),
      ballotSheetFromCandidateNames(x, c, y, i),

      ballotSheetFromCandidateNames(y, i, c, x),
      ballotSheetFromCandidateNames(y, i, c, x),

      ballotSheetFromCandidateNames(i, c, y, x),
      ballotSheetFromCandidateNames(i, c, y, x),

      ballotSheetFromCandidateNames(c, i, x, y)
    )

  }
}
