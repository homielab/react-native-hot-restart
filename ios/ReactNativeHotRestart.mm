#import "ReactNativeHotRestart.h"
#import <React/RCTReloadCommand.h>

@implementation ReactNativeHotRestart
- (void)restart{
    if ([NSThread isMainThread]) {
        RCTTriggerReloadCommandListeners(@"react-native-hot-restart: HotRestart");
    } else {
        dispatch_sync(dispatch_get_main_queue(), ^{
            RCTTriggerReloadCommandListeners(@"react-native-hot-restart: HotRestart");
        });
    }
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeReactNativeHotRestartSpecJSI>(params);
}

+ (NSString *)moduleName
{
  return @"ReactNativeHotRestart";
}

@end
