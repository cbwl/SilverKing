// SRFSConstants.h

#ifndef _SRFS_CONSTANTS_H_
#define _SRFS_CONSTANTS_H_

////////////
// includes

#include <fuse.h>


////////////
// defines

#define SRFS_HOME "/var/tmp/silverking/skfs"

#define SRFS_MAX_PERMANENT_SUFFIXES    256    
#define SRFS_MAX_PATH_LENGTH 2048 

#define SRFS_MAX_NAMESPACE_LENGTH  512
#define SRFS_MAX_NFS_ALIASES 256 
#define SRFS_MAX_EXTERNAL_DIRS 256 
#define SRFS_MAX_NO_ERROR_CACHE_PATHS 256

#define SRFS_FBID_KEY_SIZE 256

//#define SRFS_BLOCK_SIZE 1048576
//#define SRFS_BLOCK_SIZE 65536
//#define SRFS_BLOCK_SIZE 131072
//#define SRFS_BLOCK_SIZE 524288
#define SRFS_BLOCK_SIZE 262144
//#define SRFS_BLOCK_SIZE 2097152
// below is for testing only
//#define SRFS_BLOCK_SIZE 32

//#define SKFS_FB_NS "fb.2097152.d"
//#define SKFS_FB_NS "fb.1048576.d"
//#define SKFS_FB_NS "fb.65536.d"
//#define SKFS_FB_NS "fb.131072.b"
#define SKFS_FB_NS "fb.262144.b"
//#define SKFS_FB_NS "fb.524288.b"

#define SKFS_ATTR_NS "attr"
#define SKFS_DIR_NS "dir"
#define SK_SYSTEM_NS "__System__"

#define SRFS_HOSTNAME_SIZE    512
#define SRFS_MILLIS_PER_SECOND    1000

// eliminates delays looking for non-existent files, 
// but requires no bogus ENOENT reads
#define SRFS_ENABLE_DHT_ENOENT_CACHING    0

#define SRFS_OP_STAGE_DHT 1
#define SRFS_OP_STAGE_NFS 2

#define SRFS_RTS_DHT_ALPHA 0.05
#define SRFS_RTS_NFS_ALPHA 0.05
#define SRFS_RTS_DHT_OP_TIME_INITIALIZER 1
#define SRFS_RTS_NFS_OP_TIME_INITIALIZER 10
#define SRFS_DHT_OP_MIN_TIMEOUT_MS 20 
//#define SRFS_DHT_OP_MIN_TIMEOUT_MS 100
#define SRFS_DHT_OP_MAX_TIMEOUT_MS (30 * 1000)
#define SRFS_DHT_OP_DEV_WEIGHT 2.0
#define SRFS_DHT_OP_DHT_WEIGHT 0.7

#define AR_NFS_THREADS    8
#define AR_NFS_QUEUE_SIZE    32
#define AR_DHT_THREADS    8
#define AR_DHT_QUEUE_SIZE    128
#define AR_MAX_BATCH_SIZE    128
#define AR_PREFETCH_QUEUE_SIZE    1024 * 1024
#define AR_PREFETCH_THREADS    1
#define AR_PREFETCH_MAX_BATCH_SIZE    1024
#define AW_DHT_THREADS    2
#define AW_DHT_QUEUE_SIZE    1024
#define AW_MAX_BATCH_SIZE    100
#define ODW_DHT_QUEUE_PROCESSORS 3
#define ODW_DHT_THREADS_PER_QUEUE_PROCESSOR    2
#define ODW_DHT_QUEUE_SIZE    4096
#define ODW_MAX_BATCH_SIZE    100

#define ODW_RETRY_QUEUE_SIZE 131072
#define ODW_RETRY_THREADS    1
#define ODW_RETRY_MAX_BATCH_SIZE    1024
#define ODW_DEF_MIN_WRITE_INTERVAL_MILLIS   2
#define DEF_SYNC_DIR_UPDATES 1


#define DDR_DHT_THREADS    4
#define DDR_DHT_QUEUE_SIZE    512
#define DDR_MAX_BATCH_SIZE    128

#define AR_DHT_STAGE_TIMEOUT_MS (1 * 1000)
#define FBR_DHT_STAGE_TIMEOUT_MS (1 * 1000)
#define FBR_DHT_STAGE_WRITABLE_FS_TIMEOUT_MS (5 * 60 * 1000)
#define FBR_NFS_STAGE_TIMEOUT_MS (24 * 60 * 1000)

#define FBR_NFS_THREADS    16
#define FBR_NFS_QUEUE_SIZE    32

#define FBR_DHT_THREADS    8
#define FBR_DHT_QUEUE_SIZE    1024

// zero for permanent cache signals no capacity limit
#define FBR_PERMANENT_CACHE_SIZE 0
//#define FBR_TRANSIENT_CACHE_SIZE 8000
//#define FBR_TRANSIENT_CACHE_SIZE 100
//#define FBR_TRANSIENT_CACHE_SIZE 10
//#define FBR_TRANSIENT_CACHE_SIZE 1500
#define FBR_TRANSIENT_CACHE_SIZE 15000
// 7500 was in prod
//#define FBR_TRANSIENT_CACHE_SIZE 37500
//#define FBR_TRANSIENT_CACHE_EVICTION_BATCH 100
#define FBR_TRANSIENT_CACHE_EVICTION_BATCH 10
//#define FBR_TRANSIENT_CACHE_EVICTION_BATCH 1
#define FBR_MAX_BATCH_SIZE    128
//#define FBR_MAX_BATCH_SIZE    -1

#define FBW_DHT_THREADS    2
#define FBW_DHT_QUEUE_SIZE    1024
#define FBW_DHT_DELETION_THREADS    2
#define FBW_DHT_DELETION_QUEUE_SIZE    32768
#define FBW_MAX_BATCH_SIZE    128
#define FBW_DHT_SESSIONS    8

#define PBR_READAHEAD_THRESHOLD 65536
// prod was 8
//#define PBR_MAX_READAHEAD_BLOCKS 8
// below is for 524288
//#define PBR_MAX_READAHEAD_BLOCKS 10
// below is for 131072
//#define PBR_MAX_READAHEAD_BLOCKS 32
// below is for 262144
#define PBR_MAX_READAHEAD_BLOCKS 20

#define FUSE_CONF_FILE "/etc/fuse.conf"

#define BIRTHDAY_1  994414500
#define BIRTHDAY_2 1089972900
#define BIRTHDAY_3 1142417700
#define BIRTHDAY_4 1200564900
#define BIRTHDAY_5 1276769700

#define SKFS_BASE "/"
#define SKFS_WRITE_BASE "/skfs"
#define SKFS_WRITE_BASE_NO_SLASH "skfs"
#define SKFS_WRITE_BASE_LENGTH    5

#define SKFS_DEF_ENTRY_TIMEOUT_SECS    10
#define SKFS_DEF_ATTR_TIMEOUT_SECS    10
#define SKFS_DEF_NEGATIVE_TIMEOUT_SECS    10

#if FUSE_MAJOR_VERSION >= 3
#define FILLER_TAIL ,(enum fuse_fill_dir_flags)0
#else
#define FILLER_TAIL
#endif

#endif
