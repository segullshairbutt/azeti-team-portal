import { useState, useEffect } from 'react'
import { fetchUserById, fetchUserActivity } from '../api/mockApi'
import ProfileCard from './ProfileCard'
import ActivityCard from './ActivityCard'

interface Activity {
  id: number
  action: string
  timestamp: string
}

interface UserData {
  name: string
  role: string
  email: string
  lastActive: string
}

const USER_ID = 1

function UserProfile() {
  const [userData, setUserData] = useState<UserData | null>(null)
  const [recentActivity, setRecentActivity] = useState<Activity[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    const loadUserData = async () => {
      try {
        setLoading(true)
        setError(null)
        
        // Fetch user details (includes last activity timestamp)
        const user = await fetchUserById(USER_ID)
        setUserData({
          name: user.name,
          role: 'Team Member',
          email: user.email,
          lastActive: user.lastActivity?.timestamp || 'No activity yet'
        })
        
        // Fetch all activities for the user
        const activities = await fetchUserActivity(USER_ID)
        setRecentActivity(activities)
      } catch (err) {
        setError('Failed to load user data. Please try again.')
      } finally {
        setLoading(false)
      }
    }

    loadUserData()
  }, [])

  if (loading) {
    return <div className="user-profile"><p>Loading...</p></div>
  }

  if (error || !userData) {
    return <div className="user-profile"><p className="error-message">⚠️ {error}</p></div>
  }

  return (
    <div className="user-profile">
      <div className="profile-header">
        <h2>User Profile</h2>
      </div>

      <ProfileCard user={userData} />

      <div className="activity-section">
        <h3>Recent Activity</h3>

        {error && (
          <div className="error-message">
            ⚠️ {error}
          </div>
        )}

        <div className="activity-list">
          {recentActivity.length === 0 ? (
            <div className="no-activity">No recent activity</div>
          ) : (
            recentActivity.map((activity) => (
              <ActivityCard key={activity.id} activity={activity} />
            ))
          )}
        </div>
      </div>
    </div>
  )
}

export default UserProfile
