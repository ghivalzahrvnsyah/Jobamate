const express = require('express');
const {
    getUsers,
    register,
    login,
    logout,
    getProfile,
    editProfile,
    // cvUpload,
    getAllJob,
    getDetailedJob,
    jobApply
} = require("../Controller/user.js");
const verifyToken = require ("../middleware/verifyToken.js")
const refreshToken = require ("../Controller/RefreshToken.js")

const router = express.Router();

router.get('/users', verifyToken, getUsers);
router.post('/register', register);
router.post('/login', login);
router.get('/token', refreshToken);
router.delete('/logout', logout);
router.get('/users/:id', getProfile);
router.put('/users/:id', editProfile);
// router.post('/upload', cvUpload);
router.get('/jobs', getAllJob);
router.get('/job/:jobId', getDetailedJob);
router.post('/apply/:jobId', jobApply);


module.exports = router;
