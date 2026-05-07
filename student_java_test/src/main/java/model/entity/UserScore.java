package model.entity;

public class UserScore {
	private Integer scoreId;
	private Integer userId;
	private Integer score;
	private String attemptedAt;
	
	public UserScore() {
		super();
	}

	public UserScore( Integer userId, Integer score, String attemptedAt) {
		super();
		this.userId = userId;
		this.score = score;
		this.attemptedAt = attemptedAt;
	}

	public UserScore(Integer scoreId,  Integer userId, Integer score, String attemptedAt) {
		this( userId,score, attemptedAt);
		this.scoreId = scoreId;
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAttemptedAt() {
		return attemptedAt;
	}

	public void setAttemptedAt(String attemptedAt) {
		this.attemptedAt = attemptedAt;
	}

	@Override
	public String toString() {
		return "UserScore [scoreId=" + scoreId +  ", userId=" + userId + ", score=" + score
				+ ", attemptedAt=" + attemptedAt + "]";
	}


}
